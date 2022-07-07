package com.woowahan.mail.data.repository

import com.woowahan.mail.data.model.Mail
import com.woowahan.mail.data.model.MailType

object DefaultMail {
    val mails = listOf<Mail>(
        Mail(
            id = 1,
            sender = "Google",
            title = "보안알림",
            content = "Android에서 새로 로그인함 abc@gmail.com 계정이 올바른 정보인가요?",
            date = "2022-06-22",
            type = MailType.PRIMARY
        ),
        Mail(
            id = 2,
            sender = "David",
            title = "Let's Connect!",
            content = "Dear Ivy. We are seeking senior software engineering. Because they had good skill.",
            date = "2022-06-22",
            type = MailType.PRIMARY
        ),
        Mail(
            id = 3,
            sender = "구자경",
            title = "안녕하세요, 긴급 요청건으로 연락드립니다.",
            content = "첨부한 파일 확인 부탁드립니다.",
            date = "2022-06-22",
            type = MailType.PRIMARY
        ),
        Mail(
            id = 4,
            sender = "크롱",
            title = "초대장: 우아한 테크캠프 수업 - 2022년 7월 5일",
            content = "다음 일정에 초대되었습니다. 우아한테크 캠프 수업 링크입니다.",
            date = "2022-06-22",
            type = MailType.PRIMARY
        ),
        Mail(
            id = 5,
            sender = "Slido",
            title = "You how-to guide for managing Slido",
            content = "Hi there, Welcome to Slido, We have a live Q&A and poll",
            date = "2022-06-22",
            type = MailType.PRIMARY
        ),
        Mail(
            id = 6,
            sender = "LinkedIn",
            title = "Jay, Tom 님이 1촌 신청을 보냈습니다.",
            content = "인맥 키우기 LinkedIn Ivy Bae 회원님을 최근에 방문했습니다.",
            date = "2022-06-22",
            type = MailType.SOCIAL
        ),
        Mail(
            id = 7,
            sender = "김영희",
            title = "1촌 맺어요",
            content = "1촌을 맺고 싶습니다.",
            date = "2022-06-22",
            type = MailType.SOCIAL
        ),
        Mail(
            id = 8,
            sender = "Facebook",
            title = "가입한 그룹에 새로운 글이 등록됐습니다.",
            content = "새로운 소식을 확인해주세요",
            date = "2022-06-22",
            type = MailType.SOCIAL
        ),
        Mail(
            id = 9,
            sender = "크롱",
            title = "초대장: 우아한 테크캠프 수업 - 2022년 7월 5일",
            content = "다음 일정에 초대되었습니다. 우아한테크 캠프 수업 링크입니다.",
            date = "2022-06-22",
            type = MailType.SOCIAL
        ),
        Mail(
            id = 10,
            sender = "Slido",
            title = "You how-to guide for managing Slido",
            content = "Hi there, Welcome to Slido, We have a live Q&A and poll",
            date = "2022-06-22",
            type = MailType.SOCIAL
        ),
        Mail(
            id = 11,
            sender = "Zoom",
            title = "성공적인 회의 호스트를 위한 7가지 팁",
            content = "91% of Zoom customers reported higher sense. Make a good host",
            date = "2022-06-22",
            type = MailType.PROMOTION
        ),
        Mail(
            id = 12,
            sender = "Udemy",
            title = "최저가 $23부터 판매되는 강좌 - 할인 최대 30%",
            content = "최고의 Android 최고의 강좌가 할인 중입니다.",
            date = "2022-06-22",
            type = MailType.PROMOTION
        ),
        Mail(
            id = 13,
            sender = "우아한테크캠프",
            title = "5기를 모집합니다.",
            content = "우아한개발자가 되고 싶은 분들을 위한 우아한테크캠프 도전해보세요.",
            date = "2022-06-22",
            type = MailType.PROMOTION
        ),
        Mail(
            id = 14,
            sender = "Slack",
            title = "Invite your team",
            content = "Slack is most useful when you whole team sharing Information.",
            date = "2022-06-22",
            type = MailType.PROMOTION
        ),
        Mail(
            id = 15,
            sender = "무료 알고리즘 강의",
            title = "선착순 50명에게만 기회를 드립니다.",
            content = "5분만 투자하시면 알고리즈 ㅁ강의를 7일간 열람하실 수 있습니다.",
            date = "2022-06-22",
            type = MailType.PROMOTION
        ),
    )
}