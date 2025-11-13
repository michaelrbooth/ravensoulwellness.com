package com.bricknbyte.ravenSoul.services

import org.springframework.stereotype.Service

@Service
class ServicesService {
    fun closeButton(targetUrl: String = "/services?service=default"): String {
        return """
            <style>
              /* remove spacing from common layout containers where this is used */
              .row, .container, .horizontal-layout, .column, .top-align {
                margin: 0 !important;
                padding: 0 !important;
              }
    
              /* keep table flush */
              .services-table { margin: 0; }
    
              /* right-justify with no extra vertical space */
              .close-button-wrapper {
                display: flex;
                justify-content: flex-end;
                align-items: center;
                margin: 0;
                padding: 0; /* remove top/bottom spacing */
                gap: 0.25rem;
                width: 100%;
                line-height: 1;
              }
    
              .close-tab {
                display: inline-flex;
                align-items: center;
                gap: 6px;
                padding: 4px 8px; /* very small vertical space */
                background: #000;
                color: #fff;
                text-decoration: none;
                border-radius: 4px;
                font-weight: 600;
                font-size: 14px;
                line-height: 1;
                transition: background .12s ease, transform .08s ease;
                user-select: none;
              }
    
              .close-tab:hover { background: #111; transform: translateY(-1px); }
              .close-tab:focus { outline: 3px solid rgba(0,0,0,0.12); outline-offset: 2px; }
    
              @media (max-width: 480px) {
                .close-tab { padding: 3px 6px; font-size: 13px; }
              }
            </style>
    
            <div class="close-button-wrapper row">
              <a href="$targetUrl" class="close-tab" role="button" aria-label="Close and go back">✕ Services</a>
            </div>
        """.trimIndent()
    }

    fun modal(title: String, content: String): String {
        return """${closeButton()}<div class="row"><h2 class ="support-item text-center">$title</h2><div>
        
        <div class="row">$content</div>"""
    }


    fun getService(type: String): String {
        return when (type) {

            "anxiety" -> {
                val content = """
                Anxiety can feel overwhelming, racing thoughts, constant worry, restlessness, or even physical tension that makes it hard to fully relax. It often shows up as overthinking, difficulty concentrating, or feeling “on edge,” even when nothing seems wrong.
                <br><br>
                At Raven Soul Wellness, we understand how heavy anxiety can feel, and we’re here to help. Through counseling, we provide a safe space to explore the root causes of your anxiety, learn coping tools, grounding exercises, and build resilience. With coaching, we help you move forward with clarity and confidence, developing practical strategies to manage stress, shift unhelpful patterns, and create balance in daily life.
                <br><br>
                You don’t have to face anxiety alone. With compassionate guidance, it’s possible to quiet the worry, reconnect with yourself, and move toward a calmer, more grounded way of living."""
                modal("Anxiety Support", content)
            }

            "mensmentalhealth" -> {
                val content =
                    """Many men grow up being told to stay strong, not cry, and to carry their burdens quietly. While these messages may have been meant to build resilience, they often left men isolated, unheard, and carrying the world on their shoulders alone. The result has been a crisis in men’s mental health with higher rates of anxiety, depression, broken relationships, and suicide.  We believe true strength is not about suppressing emotions, but about facing them honestly and learning how to navigate them with courage. 
                <br><br>
                We support men in reclaiming healthier ways of being:   grounded in responsibility and purpose, but also open to vulnerability, connection, and authentic expression. Our goal is to walk alongside men as they rediscover that strength and emotional depth are not opposites, but partners allowing for a more balanced, meaningful, and hopeful life.
                """
                modal("Men's Mental Health", content)
            }

            "womansmh" -> {
                val content =
                    """Life as a woman often comes with unique pressures, expectations, and challenges that can leave us feeling overwhelmed, disconnected, or unsure of who we truly are. Through compassionate counseling and empowering coaching, we support women in navigating life transitions, healing from emotional struggles, and reconnecting with their authentic selves.<br><br>
Together, we explore the patterns, beliefs, and barriers that may be holding you back, while cultivating tools for resilience, confidence, and self trust. Whether you are facing relationship challenges, career stress, grief, or personal growth obstacles, our work focuses on strengthening your voice, reclaiming your power, and stepping into the most genuine version of yourself.<br><br>
This is a space where your story is honored, your struggles are validated, and your potential is nurtured. With guidance, practical strategies, and supportive accountability, you can overcome challenges, embrace your worth, and create a life that feels aligned with who you truly are."""
                modal("Women's Mental Health", content)
            }

            "relationships" -> {
                val content =
                    """Every relationship has seasons of growth, challenge, and change. Whether you’re navigating conflict, struggling with communication, or simply wanting to strengthen your connection, counseling and coaching provide a supportive space to work together with compassion.
<br><br>
We focus on helping you and your partner discover healthier ways to listen, express your needs, and truly hear one another. Through guided conversations and practical tools, you’ll learn how to break unhelpful patterns, deepen understanding, and build a foundation of trust and respect.
<br><br>
Our goal is not only to resolve current challenges but to equip you with skills that support long-term connection, honest communication, emotional awareness, and the ability to navigate differences with empathy. Together, we create space for each person to feel valued, understood, and supported in building a stronger, more fulfilling relationship."""
                modal("Relationships", content)
            }

            "grief" -> {
                val content =
                    """Grief can feel overwhelming and isolating. Our Grief & Loss Counseling and Coaching provides a safe, supportive space to process your emotions, honor your experiences, and navigate the complex journey of grief.
<br><br>
With our grief specialists, we dig deeper into understanding what kind of griever you are, offering personalized coping strategies and education about why you are feeling what you are feeling and the natural process of grieving. Together, we explore ways to manage intense emotions, adapt to life changes, and find resilience and meaning through loss. Our goal is to help you heal, remember, and move forward with compassion for yourself.
<br><br>
Our Grief & Loss Counseling and Coaching provides a supportive space to process emotions and navigate life’s transitions. With our grief specialists, we help you understand your grieving style, provide coping strategies, and educate you on the natural process of grief.
"""
                modal("Grief and Loss", content)
            }

            "petloss" -> {
                val content =
                    """We provide guidance through the grief of saying goodbye to an animal companion by death, separation, or unexpected loss. because our companions are family too. The bond we share with them is unique, deep, and often difficult for others to fully understand. Yet their absence leaves a very real emptiness. Too often, people minimize this grief or dismiss it as “silly,” which can leave you feeling isolated in your pain. We recognize the importance of honoring these beloved companions, acknowledging the joy they brought, and creating space for the grief that follows their loss. In our work together, you will have a safe place to remember, mourn, and begin to heal without judgment, and with the understanding that love, in all its forms, deserves to be honored."""
                modal("Pet Loss", content)
            }

            "separation" -> {
                val content =
                    """The end of a relationship can be one of the most painful and life-altering experiences. Whether you are in the process of uncoupling, going through a divorce, or adjusting to life after separation, it’s normal to feel a mix of grief, uncertainty, and overwhelming emotions.
Through counseling and coaching, we provide a compassionate space to process the stages of loss, navigate the practical and emotional challenges, and begin building a path forward. Together, we explore healthy coping strategies, emotional healing, and ways to rediscover your sense of self outside the relationship.
<br><BR>Our goal is to help you move through this transition with strength, clarity, and resilience supporting you not only in letting go but also in creating space for new beginnings, growth, and a future that feels authentic and whole."""
                modal("Divorce, Separation and Uncoupling", content)
            }

            "growth" -> {
                val content =
                    """True growth begins with self-discovery. Personal Growth Counseling and Coaching offers a safe and reflective space to look inward, explore who you are, and uncover what truly matters to you. Through guided conversations, self-reflective exercises, and personalized assessments, we help you gain clarity on your values, strengths, and areas for growth.
<br><br>
Whether you’re seeking direction, wanting to reconnect with your authentic self, or navigating a life transition, our work together focuses on empowering you to step into your fullest potential. This is a journey of self-awareness, healing, and transformation—supporting you in not just finding yourself, but creating a life that feels aligned, meaningful, and whole.
<br><br> 
Let’s find your authentic YOU!
"""
                modal("Personal Growth", content)
            }

            "neurodiverse" -> {
                val content =
                    """Living with a neurodiverse mind often means experiencing the world in unique and powerful ways—while also facing challenges in work, communication, relationships, and daily life. Neurodiversity Counseling and Coaching provides a supportive and nonjudgmental space to help you navigate these challenges and celebrate your strengths.
<br><br>
Together, we focus on understanding how your brain works best, building strategies for managing stress, improving communication, and strengthening relationships. We also explore practical tools to support you in your personal and professional life, so you can thrive authentically, not just adapt.
<br><br>
Our goal is to empower you to embrace your neurodiversity, develop confidence in your abilities, and create a life that feels balanced, supported, and true to who you are."""
                modal("Neurodiversity", content)
            }

            "adhd" -> {
                val content =
                    """Living with ADHD can bring both unique strengths and daily challenges. At times, you may feel misunderstood in your relationships, overwhelmed at work, or frustrated by patterns that seem hard to break. With the support of our certified counselors and ADHD-trained coaches, we provide a safe and encouraging space to better understand yourself and build strategies that truly work for you.
<br><br>
Together, we explore how ADHD impacts your communication, relationships, and career while helping you recognize the “why” behind your choices and emotions. We also focus on practical tools for managing conflict, calming anger, and improving focus—all while celebrating the powerful, creative, and unique benefits of being authentically you.
Our goal is not just to help you cope, but to empower you to thrive—with confidence, self-acceptance, and strategies that support success in every part of your life."""
                modal("ADHD", content)
            }

            "career" -> {
                val content = """Career Planning & Development Counseling and Coaching
Navigating your career path can feel overwhelming, whether you’re just starting out, considering a change, or seeking advancement. Career Planning and Development Counseling and Coaching provides a supportive space to clarify your goals, identify your strengths, and create actionable strategies for professional growth.
<br><br>
Together, we explore career interests, develop decision-making skills, and build confidence in your choices. We help you navigate challenges such as workplace dynamics, skill gaps, and career transitions while empowering you to pursue a path that aligns with your values, passions, and long-term goals. Our aim is to support you in achieving meaningful, fulfilling, and sustainable career success."""
                modal("Career Planning and Development", content)
            }
            "diagnose" -> {
                val content = """Receiving a health diagnosis or managing a chronic illness can be overwhelming, emotional, and life-changing. Illness Counseling provides a supportive space to process your feelings, understand your emotional reactions and grief, and navigate the practical and psychological challenges that come with your diagnosis.
<br><br>
Together, we focus on coping strategies, stress management, and building resilience, while helping you communicate effectively with loved ones and healthcare providers. Our goal is to empower you to face health challenges with clarity, strength, and self-compassion, supporting not only your physical journey but your emotional well-being as well.
"""
                modal("Guided Support for Life-Altering Diagnoses", content)
            }
            "family" ->{
                val content = """Families come in all shapes and sizes, and every family faces unique challenges. Our Family and Parenting Counseling provides a compassionate space to listen, understand, and support families through the ups and downs of parenting, relationships, and household dynamics.
<br><br>
With over 15 years of experience, we work with all types of families—including those with special needs—to improve communication, strengthen relationships, and develop practical strategies for managing challenges. Our goal is to help families build connection, understanding, and resilience, creating a supportive environment where every member can thrive."""
                modal("Family Counseling", content)
            }
            "lgbtq" -> {
                val content = """LGBTQAI2S+ & Gender Identity Counseling and Coaching
Exploring your gender identity or navigating the complexities of LGBTQAI2S+ experiences can bring unique challenges, questions, and opportunities for growth. Our counseling and coaching provides a safe, affirming space to help you explore your authentic self, understand your identity, and navigate personal, relational, and societal challenges.
<br><br>
Together, we focus on building self-acceptance, developing healthy communication in relationships, and creating strategies to manage stress, discrimination, or conflict. Whether you are questioning, transitioning, or simply seeking support in living openly and authentically, our goal is to empower you to embrace your true identity with confidence, resilience, and pride.
<br><br>
Our LGBTQAI2S+ and Gender Identity Counseling and Coaching provides a safe, affirming space to explore your authentic self and navigate personal, relational, and societal challenges. We help you build self-acceptance, strengthen communication, and develop strategies to live openly and confidently.
"""
                modal("LGBTQAI2S+ & Gender Identity", content)
            }
            "lifestyles" -> {
                val content = """Navigating non-traditional relationship structures—such as polyamory, ethical non-monogamy, or conscious monogamy—comes with unique challenges, opportunities, and emotions. Our counseling and coaching provides a safe, nonjudgmental space to explore your relationships, understand your needs, and build healthy, fulfilling connections.
<br><br>
We focus on improving communication, setting and respecting boundaries, managing jealousy, and navigating complex emotions while honoring the values and agreements that work for you and your partners. Whether you’re new to alternative lifestyles or seeking guidance to strengthen your current relationships, our goal is to empower you to cultivate authentic, ethical, and thriving connections that reflect who you truly are.
<br><br>
Our Alternative Lifestyles Counseling and Coaching supports individuals and partners in polyamorous, ethically non-monogamous, and conscious monogamous relationships. We help you navigate communication, boundaries, and emotions while cultivating authentic, healthy, and fulfilling connections.
"""
                modal("Alternative Lifestyles", content)
            }
            "intimacy" -> {
                val content = """Healthy intimacy is a cornerstone of fulfilling relationships, yet many people struggle with connection, vulnerability, and closeness. Intimacy Counseling provides a safe and supportive space to explore emotional, physical, and relational intimacy challenges.
We help you and your partner (or you individually) build trust, enhance communication, and navigate barriers to closeness. Through guidance and practical strategies, you’ll learn to foster deeper connection, express your needs openly, and create a satisfying and authentic intimate life.
<br><br>
Our goal is to support you in cultivating meaningful, nurturing, and sustainable intimacy that strengthens both your relationship and your sense of self."""
                modal("Intimacy", content)
            }
            "precommit" -> {
                val content = """Whether you are preparing for marriage or forming a partnership in your own way, Pre-Commitment Counseling provides a safe and supportive space to explore your values, expectations, and shared goals. We help couples and partners identify common ground, improve communication, and set a strong foundation for a loving, respectful, and lasting relationship.
<br><br>
Through guided conversations and practical exercises, you’ll gain clarity on your priorities, navigate potential challenges, and develop strategies for building a partnership that reflects both your individual needs and shared vision. Our goal is to support you in creating a relationship rooted in understanding, trust, and mutual growth.
<br><br>
Pre-Commitment Counseling helps couples and partners explore shared values, expectations, and goals before committing to a lifelong or chosen partnership. We provide guidance and tools to strengthen communication, clarify priorities, and create a strong foundation for a loving, lasting relationship.
"""
                modal("Pre-Commitment", content)
            }
            "spiritual" -> {
                val content = """Spiritual Counseling provides a supportive space to explore your inner life, connect with your values, and find meaning and purpose in your journey. Whether you are navigating personal challenges, life transitions, or seeking deeper self-understanding, this counseling approach helps you align with your authentic self and inner guidance.
<br><br>Together, we explore your beliefs, strengths, and spiritual practices to foster growth, resilience, and clarity. Through reflective conversations and practical strategies, you’ll gain insight, peace, and empowerment to navigate life with intention, balance, and fulfillment."""
                modal("Spiritual Counseling", content)
            }
            "ikigai" -> {
                val content = """IKIGAI is a Japanese concept that means “reason for being” — the sweet spot where your passions, talents, values, and what the world needs intersect. IKIGAI coaching at Raven Soul Wellness helps you uncover your purpose, align your goals, and live with intention and fulfillment.
<br><br>
Through personalized guidance, reflective exercises, and practical strategies, our coaches support you in discovering what truly energizes and motivates you, helping you make choices that feel meaningful and authentic. Whether you’re navigating a career change, personal growth, or life transitions, IKIGAI coaching empowers you to create a life that feels purposeful and aligned with your deepest values.
"""
                modal("Ikigai Coaching", content)
            }
            "adoption" -> {
                val content = """Adoption is a journey filled with love, complexity, and sometimes unexpected challenges. At Raven Soul Wellness, we understand adoption not only from professional training but also through lived experience. Our services are designed to support individuals, couples, and families who are navigating the unique realities of adoption and the many transitions that may come with it.
<br><br>
We provide a safe and non-judgmental space to explore:
<ul>
<li>The joys and challenges of adoption, from preparation to lifelong integration.</li>
<li>Feelings of loss, identity, or grief that may arise for adoptees, birth parents, and adoptive families.</li>
<li>Unexpected changes along the adoption path, including disrupted placements or evolving relationships.</li>
<li>Navigating conversations about sperm donors, egg donors, and surrogacy, and their impact on family identity.</li>
<li>The questions and emotions tied to biological connections—whether you’re longing for more information, building relationships with biological parents, or processing what it means not to know.</li>
<li>Life transitions that can bring adoption-related feelings back to the surface, such as becoming a parent, experiencing loss, or facing major life changes.</li>
</ul>
<br><br>
Through counseling and coaching, we help you explore your story, strengthen resilience, and honor every layer of your experience. Whether you are an adoptee, adoptive parent, birth parent, or part of a donor-conceived family, you are not alone. We are here to walk alongside you as you navigate identity, belonging, and healing with compassion and clarity."""
                modal("Adoption Support", content)
            }
            "fertility" -> {
                val content = """The path to parenthood is rarely a straight line. For many, it includes heartbreak, grief, and deeply personal decisions. At Raven Soul Wellness, we provide compassionate counseling and coaching for individuals and families navigating the emotional complexities of fertility challenges, pregnancy loss, abortion, and unexpected outcomes.
We hold space for:
<br>
<ul>
<li>IVF & Fertility Journeys – Supporting the hopes, stress, and emotional rollercoaster that come with treatments, waiting, and uncertainty.</li>
<li>Miscarriage & Stillbirth – Honoring your grief, helping you process the loss, and finding ways to carry your baby’s memory with you.</li>
<li>Abortion Support – Providing non-judgmental care for those who have chosen or are considering abortion, recognizing the range of emotions and circumstances that surround this decision.</li>
<li>Pregnancy After Loss – Navigating the hope, fear, and vulnerability of trying again.</li>
<li>Unexpected Transitions – Adjusting to the reality of outcomes that look different than you imagined, including child-free living.</li>
</ul>
Our work acknowledges the depth of your loss and the strength it takes to keep moving forward. Here, your story is respected and your emotions are valid. Whether you need a place to grieve, process decisions, or rebuild hope, we walk alongside you with compassion, honesty, and understanding.
"""
                modal("Fertility, Pregnancy & Reproductive Loss Support", content)
            }
            "attachment" -> {
                val content = """<h3>Secure Attachment</h3>
 A balanced style where you feel comfortable with closeness, trust, and independence in relationships. People with secure attachment usually find it easier to communicate needs, set healthy boundaries, and feel safe in connections.
<br><br>
<h3>Anxious Attachment</h3>
 Often marked by a strong need for closeness and reassurance, but also a fear of abandonment. This style can bring deep care for others, yet sometimes create worry about being “too much” or not enough.
<br><br>
<h3>Avoidant Attachment</h3>
 Characterized by valuing independence and sometimes keeping emotional distance to feel safe. While avoidant styles can foster strength and self-reliance, they can also make it difficult to ask for support or open up fully in relationships.
<br><br>
<h3>Disorganized (Fearful-Avoidant) Attachment</h3>
 A mix of both anxious and avoidant traits, often linked to past pain or inconsistent caregiving. This style may lead to wanting closeness while also feeling fear or mistrust. With support, it’s possible to create more safety, stability, and trust in relationships.
 """
                modal("Attachment Styles", content)
            }
            else -> {
                """
                <div class="row">
        <div class="container horizontal-layout">
            <div class="column top-align">
                <h2 class="section-title">Services</h2>
               <!-- HTML -->
                <style>
                  .services-table {
                    width: 100%;
                    border-collapse: collapse;
                    table-layout: fixed;
                  }
                  .services-table td {
                    padding: 8px 12px;
                    vertical-align: top;
                    word-wrap: break-word;
                  }
                  @media (max-width: 640px) {
                    .services-table, .services-table tbody, .services-table tr, .services-table td {
                      display: block;
                      width: 100%;
                    }
                    .services-table td { padding: 6px 0; }
                  }
                </style>
                
                <table class="services-table" aria-label="Services">
                  <tbody>
                    <tr>
                      <td class="support-item"><a class="support-item" href="/services?service=adhd">ADHD</a></td>
                      <td class="support-item"><a class="support-item" href="/services?service=adoption">Adoption Support</a></td>
                      <td class="support-item"><a class="support-item" href="/services?service=lifestyles">Alternative lifestyles</a></td>
                    </tr>
                    <tr>
                      <td class="support-item"><a class="support-item" href="/services?service=attachment">Attachment Styles</a></td>
                      <td class="support-item"><a class="support-item" href="/services?service=anxiety">Anxiety</a></td>
                      <td class="support-item"><a class="support-item" href="/services?service=career">Career planning and development</a></td>
                    </tr>
                    <tr>
                      <td class="support-item"><a class="support-item" href="/services?service=separation">Divorce, separation, and uncoupling</a></td>
                      <td class="support-item"><a class="support-item" href="/services?service=family">Family counseling</a></td>
                      <td class="support-item"><a class="support-item" href="/services?service=fertility">Fertility, Pregnancy &amp; Reproductive Loss Support for Men and Women</a></td>
                    </tr>
                    <tr>
                      <td class="support-item"><a class="support-item" href="/services?service=grief">Grief and loss</a></td>
                      <td class="support-item"><a class="support-item" href="/services?service=diagnose">Guided support for life-altering diagnoses</a></td>
                      <td class="support-item"><a class="support-item" href="/services?service=ikigai">Ikigai coaching</a></td>
                    </tr>
                    <tr>
                      <td class="support-item"><a class="support-item" href="/services?service=intimacy">Intimacy counseling</a></td>
                      <td class="support-item"><a class="support-item" href="/services?service=lgbtq">LGBTQAI2S+ &amp; Gender identity</a></td>
                      <td class="support-item"><a class="support-item" href="/services?service=mensmentalhealth">Men’s mental health</a></td>
                    </tr>
                    <tr>
                      <td class="support-item"><a class="support-item" href="/services?service=neurodiverse">Neurodiversity</a></td>
                       <td class="support-item"><a class="support-item" href="/services?service=petloss">Pet loss</a></td>
                      <td class="support-item"><a class="support-item" href="/services?service=growth">Personal growth</a></td>
                    </tr>
                    <tr>
                      <td class="support-item"><a class="support-item" href="/services?service=precommit">Pre-commitment counseling</a></td>
                      <td class="support-item"><a class="support-item" href="/services?service=relationships">Relationships counseling</a></td>
                      <td class="support-item"><a class="support-item" href="/services?service=spiritual">Spiritual</a></td>
                    </tr>
                    <tr>
                      <td class="support-item"><a class="support-item" href="/services?service=womansmh">Women’s mental health</a></td>
                      <td></td>
                      <td></td>
                    </tr>
                  </tbody>
                </table>
                
            </div>
            
        </div>
    </div>
            """.trimIndent()
            }
        }
    }
}