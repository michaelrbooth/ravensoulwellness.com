package com.bricknbyte.ravenSoul.services

import org.springframework.stereotype.Service

@Service
class ServicesService {
    fun getService(type: String): String{
        return when(type){
            "example" -> {"sup?"}
            else -> {"""
                <div class="row">
        <div class="container horizontal-layout">
            <div class="column top-align">
                <h2 class="section-title">Services</h2>
                <UL class="support-list">
                    <LI class="support-list">ADHD</LI>
                    <LI class="support-item">Adoption Support</LI>
                    <LI class="support-item">Alternative lifestyles</LI>
                    <LI class="support-item">Attachment Styles</LI>
                    <LI class="support-item">Anxiety</LI>
                    <LI class="support-item">Career planning and development</LI>
                    <LI class="support-item">Divorce, separation, and uncoupling</LI>
                    <LI class="support-item">Family counseling</LI>
                    <LI class="support-item">Fertility, Pregnancy & Reproductive Loss Support for Men and Women</LI>
                    <LI class="support-item">Grief and loss</LI>
                    <LI class="support-item">Guided support for life-altering diagnoses</LI>
                    <LI class="support-item">Ikigai coaching</LI>
                    <LI class="support-item">Intimacy counseling</LI>
                    <LI class="support-item">LGBTQAI2S+ & Gender identity</LI>
                    <LI class="support-item">Men’s mental health</LI>
                    <LI class="support-item">Neurodiversity</LI>
                    <LI class="support-item">Pet loss</LI>
                    <LI class="support-item">Personal growth</LI>
                    <LI class="support-item">Pre-commitment counseling</LI>
                    <LI class="support-item">Relationships counseling</LI>
                    <LI class="support-item">Spiritual</LI>
                    <LI class="support-item">Women’s mental health</LI>

                </UL>

                <!--p>Additional Areas of Expertise </p-->
            </div>
            <div class="column image-column">
                <img src="images/team2.png" alt="Support Groups" class="support-image">
            </div>
        </div>
    </div>
            """.trimIndent()}
        }
    }
}