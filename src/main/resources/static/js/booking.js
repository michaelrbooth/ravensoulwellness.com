// Google Calendar API integration
const GOOGLE_API_KEY = 'YOUR_API_KEY';
const CLIENT_ID = 'YOUR_CLIENT_ID';
const API_SCOPE = 'https://www.googleapis.com/auth/calendar';

class BookingSystem {
    constructor() {
        this.selectedCounselor = null;
        this.selectedDateTime = null;
        this.selectedDuration = null;

        this.init();
    }

    init() {
        // Load the Google API client
        gapi.load('client:auth2', () => {
            gapi.client.init({
                apiKey: GOOGLE_API_KEY,
                clientId: CLIENT_ID,
                scope: API_SCOPE
            }).then(() => {
                this.initializeEventListeners();
                this.initializeCalendar();
            });
        });
    }

    initializeEventListeners() {
        // Session button listeners
        document.querySelectorAll('.session-btn').forEach(btn => {
            btn.addEventListener('click', (e) => {
                this.selectedCounselor = e.target.dataset.calendarId;
                this.selectedDuration = parseInt(e.target.dataset.duration);
                this.loadAvailability();
            });
        });

        // Form submission
        document.getElementById('session-booking-form').addEventListener('submit', (e) => {
            e.preventDefault();
            this.handleBookingSubmission();
        });
    }

    initializeCalendar() {
        // Initialize calendar with FullCalendar
        this.calendar = new FullCalendar.Calendar(document.getElementById('booking-calendar'), {
            initialView: 'dayGridMonth',
            selectable: true,
            select: (info) => {
                this.handleDateSelection(info.start);
            }
        });
        this.calendar.render();
    }

    async loadAvailability() {
        if (!this.selectedCounselor) return;

        try {
            const response = await gapi.client.calendar.freebusy.query({
                timeMin: new Date().toISOString(),
                timeMax: new Date(Date.now() + 30 * 24 * 60 * 60 * 1000).toISOString(),
                items: [{ id: this.selectedCounselor }]
            });

            this.updateCalendarWithAvailability(response.result.calendars);
        } catch (error) {
            console.error('Error loading availability:', error);
        }
    }

    updateCalendarWithAvailability(busyTimes) {
        // Update calendar with available time slots
        this.calendar.removeAllEvents();
        // Add events based on busy times
        // Implement your availability logic here
    }

    async handleBookingSubmission() {
        const formData = {
            name: document.getElementById('client-name').value,
            email: document.getElementById('client-email').value,
            phone: document.getElementById('client-phone').value,
            notes: document.getElementById('client-notes').value
        };

        try {
            const event = {
                summary: `Counseling Session with ${formData.name}`,
                description: formData.notes,
                start: {
                    dateTime: this.selectedDateTime.toISOString()
                },
                end: {
                    dateTime: new Date(this.selectedDateTime.getTime() + this.selectedDuration * 60000).toISOString()
                },
                attendees: [
                    { email: formData.email }
                ]
            };

            await gapi.client.calendar.events.insert({
                calendarId: this.selectedCounselor,
                resource: event,
                sendUpdates: 'all'
            });

            this.showBookingConfirmation();
        } catch (error) {
            console.error('Error creating booking:', error);
        }
    }

    showBookingConfirmation() {
        // Implement booking confirmation UI
        alert('Booking confirmed! Check your email for details.');
    }
}

// Initialize booking system when DOM is loaded
document.addEventListener('DOMContentLoaded', () => {
    new BookingSystem();
});