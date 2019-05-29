package o1.mobile.softhanjolup.DB;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class UniBook_DBHelper extends SQLiteOpenHelper {
    String sql;

    public UniBook_DBHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }
    @Override
    public void onCreate(SQLiteDatabase db) {
        //bookNum integer, title string, author string
        sql = "CREATE TABLE UniBook (_id INTEGER PRIMARY KEY AUTOINCREMENT," + " bookNum INTEGER, title TEXT, author TEXT);";
        db.execSQL(sql);

        db.execSQL("INSERT INTO UniBook VALUES(NULL, '1', '고래', '천명관');");
        db.execSQL("INSERT INTO UniBook VALUES(NULL, '2', '그 많던 싱아는 누가 다 먹었을까', '박완서');");
        db.execSQL("INSERT INTO UniBook VALUES(NULL, '3', '김수영 전집1-시', '김수영');");
        db.execSQL("INSERT INTO UniBook VALUES(NULL, '4', '당신들의 천국', '이청준');");
        db.execSQL("INSERT INTO UniBook VALUES(NULL, '5', '덕혜옹주', '권비영');");
        db.execSQL("INSERT INTO UniBook VALUES(NULL, '6', '두근두근 내 인생', '김애란');");
        db.execSQL("INSERT INTO UniBook VALUES(NULL, '7', '밤은 노래한다', '김연수');");
        db.execSQL("INSERT INTO UniBook VALUES(NULL, '8', '사평역에서', '곽재구 ');");
        db.execSQL("INSERT INTO UniBook VALUES(NULL, '9', '소년이 온다', '한강');");
        db.execSQL("INSERT INTO UniBook VALUES(NULL, '10', '아랑은 왜', '김영하');");
        db.execSQL("INSERT INTO UniBook VALUES(NULL, '11', '아름다운 날들', '성석제');");
        db.execSQL("INSERT INTO UniBook VALUES(NULL, '12', '원미동 사람들', '양귀자');");
        db.execSQL("INSERT INTO UniBook VALUES(NULL, '13', '정본 백석 시집', '백석');");
        db.execSQL("INSERT INTO UniBook VALUES(NULL, '14', '토지', '박경리');");
        db.execSQL("INSERT INTO UniBook VALUES(NULL, '15', '입 속의 검은 잎', '기형도 ');");
        db.execSQL("INSERT INTO UniBook VALUES(NULL, '16', '어린왕자', '생택쥐페리, 송태효 옮김');");
        db.execSQL("INSERT INTO UniBook VALUES(NULL, '17', '1984', '조지 오웰');");
        db.execSQL("INSERT INTO UniBook VALUES(NULL, '18', '거미 여인의 키스', '마누엘 푸익, 송병선 옮김');");
        db.execSQL("INSERT INTO UniBook VALUES(NULL, '19', '라마야나', 'R. K. 나라얀');");
        db.execSQL("INSERT INTO UniBook VALUES(NULL, '20', '노르웨이의 숲', '무라카미 하루키');");
        db.execSQL("INSERT INTO UniBook VALUES(NULL, '21', '뉴욕 3부작', '폴 오스터');");
        db.execSQL("INSERT INTO UniBook VALUES(NULL, '22', '루쉰 소설 전집', '루쉰, 김시준옮김');");
        db.execSQL("INSERT INTO UniBook VALUES(NULL, '23', '맥베스', '예익스피어');");
        db.execSQL("INSERT INTO UniBook VALUES(NULL, '24', '바보들을 위한 학교', '사샤 소콜로프');");
        db.execSQL("INSERT INTO UniBook VALUES(NULL, '25', '백년의 고독', '가브리엘 마르케스');");
        db.execSQL("INSERT INTO UniBook VALUES(NULL, '26', '모든 것이 산산이 부서지다', '치누아 아체베');");
        db.execSQL("INSERT INTO UniBook VALUES(NULL, '27', '악의 꽃', '보들레르');");
        db.execSQL("INSERT INTO UniBook VALUES(NULL, '28', '에르미따', '시오닐 호세');");
        db.execSQL("INSERT INTO UniBook VALUES(NULL, '29', '일리아스', '호메로스, 천병희 옮김');");
        db.execSQL("INSERT INTO UniBook VALUES(NULL, '30', '잃어버린 환상', '오노레 드 발자크');");
        db.execSQL("INSERT INTO UniBook VALUES(NULL, '31', '적절한 균형', '로힌턴 미스트리');");
        db.execSQL("INSERT INTO UniBook VALUES(NULL, '32', '제노사이드', '다카노 가즈아키');");
        db.execSQL("INSERT INTO UniBook VALUES(NULL, '33', '제로 형제의 시련', '윌레 소잉카');");
        db.execSQL("INSERT INTO UniBook VALUES(NULL, '34', '창문 넘어 도망친 100세 노인', '요나스 요나손');");
        db.execSQL("INSERT INTO UniBook VALUES(NULL, '35', '천 개의 찬란한 태양', '할레드 호세이니');");
        db.execSQL("INSERT INTO UniBook VALUES(NULL, '36', '카라마조프가의 형제들', '도스토예프스키');");
        db.execSQL("INSERT INTO UniBook VALUES(NULL, '37', '파우스트', '요한 볼프강 폰 괴테');");
        db.execSQL("INSERT INTO UniBook VALUES(NULL, '38', '파이 이야기', '얀 마텔');");
        db.execSQL("INSERT INTO UniBook VALUES(NULL, '39', '폭푸으이 언덕', '에밀리 브론테, 김정아 옮김');");
        db.execSQL("INSERT INTO UniBook VALUES(NULL, '40', '전쟁의 슬픔', '바오 인, 하재홍 옮김');");
        db.execSQL("INSERT INTO UniBook VALUES(NULL, '41', '증여론', '마르셀 모스, 이상률 옮김');");
        db.execSQL("INSERT INTO UniBook VALUES(NULL, '42', '간디 자서전', '마하트마 간디, 박홍규 옮김');");
        db.execSQL("INSERT INTO UniBook VALUES(NULL, '43', '감옥으로부터으 ㅣ사색', '신영복');");
        db.execSQL("INSERT INTO UniBook VALUES(NULL, '44', '검은 피부 하얀 가면', '프란츠 파농, 이석호 옮김');");
        db.execSQL("INSERT INTO UniBook VALUES(NULL, '45', '경영의 모험', '존 브룩스');");
        db.execSQL("INSERT INTO UniBook VALUES(NULL, '46', '고독한 군중', '데이비드 리스먼, 류근일 옮김');");
        db.execSQL("INSERT INTO UniBook VALUES(NULL, '47', '국부론', '아담 스미스, 김수행 옮김');");
        db.execSQL("INSERT INTO UniBook VALUES(NULL, '48', '나를 부르는 숲', '빌 브라이슨');");
        db.execSQL("INSERT INTO UniBook VALUES(NULL, '49', '낮선 곳에서 나를 마난다', '한국문화인류학회');");
        db.execSQL("INSERT INTO UniBook VALUES(NULL, '50', '대한민국은 왜?', '김동춘');");
        db.execSQL("INSERT INTO UniBook VALUES(NULL, '51', '리바이어던', '도마스 홉스, 신재일 옮김');");
        db.execSQL("INSERT INTO UniBook VALUES(NULL, '52', '미움받을 용기', '기시미 이치로');");
        db.execSQL("INSERT INTO UniBook VALUES(NULL, '53', '분노하라', '스테판 에셀');");
        db.execSQL("INSERT INTO UniBook VALUES(NULL, '54', '블루오션 전략', '김위찬, 르네 마보안');");
        db.execSQL("INSERT INTO UniBook VALUES(NULL, '55', '사회를 구하는 경제학', '조형근, 김종배');");
        db.execSQL("INSERT INTO UniBook VALUES(NULL, '56', '삶을 위한 철학수업', '이진경');");
        db.execSQL("INSERT INTO UniBook VALUES(NULL, '57', '생명의 윤리를 말하다', '마이클 센델');");
        db.execSQL("INSERT INTO UniBook VALUES(NULL, '58', '세계화의 윤리', '피터 싱어');");
        db.execSQL("INSERT INTO UniBook VALUES(NULL, '59', '소크라테스의 변명', '플라톤, 강철웅 옮김');");
        db.execSQL("INSERT INTO UniBook VALUES(NULL, '60', '연암에게 글쓰기를 배우다', '박현찬, 서른');");
        db.execSQL("INSERT INTO UniBook VALUES(NULL, '61', '예루살렘의 아이히만', '한나 아렌트');");
        db.execSQL("INSERT INTO UniBook VALUES(NULL, '62', '용재총화', '성현, 김남이-전지원 옮김');");
        db.execSQL("INSERT INTO UniBook VALUES(NULL, '63', '우주의 끝에서 철학하기', '마크 롤랜즈');");
        db.execSQL("INSERT INTO UniBook VALUES(NULL, '64', '인간답게 죽는다는 것', '야마카타 겐지');");
        db.execSQL("INSERT INTO UniBook VALUES(NULL, '65', '조화로운 삶', '헬렌&스콧 니어링');");
        db.execSQL("INSERT INTO UniBook VALUES(NULL, '66', '촘스키와 푸코, 인간의 본성을 말하다', '노암 촘스키, 미셀 푸코');");
        db.execSQL("INSERT INTO UniBook VALUES(NULL, '67', '텔레비전에 대하여', '피에르 부르디');");
        db.execSQL("INSERT INTO UniBook VALUES(NULL, '68', '파놉티콘', '홍성욱');");
        db.execSQL("INSERT INTO UniBook VALUES(NULL, '69', '프로이트의 의자', '정도언');");
        db.execSQL("INSERT INTO UniBook VALUES(NULL, '70', '호모 루덴스', '요한 호이징아, 김윤수');");
        db.execSQL("INSERT INTO UniBook VALUES(NULL, '71', '과학혁명의 구조', '토마스 쿤, 홍성욱-김명자 옮김');");
        db.execSQL("INSERT INTO UniBook VALUES(NULL, '72', '부분과 전체', '베르너 하아젠베르크, 김용준 옮김');");
        db.execSQL("INSERT INTO UniBook VALUES(NULL, '73', '인간은 왜 늙는가', '스티븐 어스태드, 최대천 옮김');");
        db.execSQL("INSERT INTO UniBook VALUES(NULL, '74', '객관성의 칼날', '찰스 길리스피');");
        db.execSQL("INSERT INTO UniBook VALUES(NULL, '75', '그림으로 보는 시간의 역사', '스티븐 호킹');");
        db.execSQL("INSERT INTO UniBook VALUES(NULL, '76', '다윈의 서재 - 진화하는 지식의 최전선에 서다', '장대익');");
        db.execSQL("INSERT INTO UniBook VALUES(NULL, '77', '만들어진 신 - 신은 과연 인간을 창조했는가?', '리처드 도킨스');");
        db.execSQL("INSERT INTO UniBook VALUES(NULL, '78', '빅 히스토리', '데이비드 크리스천, 밥 베인빅');");
        db.execSQL("INSERT INTO UniBook VALUES(NULL, '79', '우연을 길들이다', '이언 해킹, 정해경');");
        db.execSQL("INSERT INTO UniBook VALUES(NULL, '80', '인간적인, 너무나 인간적인 뇌', '리처드 레스탁');");
        db.execSQL("INSERT INTO UniBook VALUES(NULL, '81', '의학, 인문으로 치유하다', '예병일');");
        db.execSQL("INSERT INTO UniBook VALUES(NULL, '82', '종의 기원 2013, 옥스퍼드컬러판', '찰스 로버트 다윈');");
        db.execSQL("INSERT INTO UniBook VALUES(NULL, '83', '축적의 시간', '서울대학교 공과대학');");
        db.execSQL("INSERT INTO UniBook VALUES(NULL, '84', '침묵의 봄', '레이텔 카슨');");
        db.execSQL("INSERT INTO UniBook VALUES(NULL, '85', 'LHC, 현대 물리학의 최전선', '이강영');");
        db.execSQL("INSERT INTO UniBook VALUES(NULL, '86', '건축가 없는 건축', '버날드 루돌프스키');");
        db.execSQL("INSERT INTO UniBook VALUES(NULL, '87', '그림 아는 만큼 보인다', '손철주');");
        db.execSQL("INSERT INTO UniBook VALUES(NULL, '88', '기술복제시대의 예술작품 사진으 ㅣ작은 역사 외', '발터 벤야민, 최성만 옮김');");
        db.execSQL("INSERT INTO UniBook VALUES(NULL, '89', '무량수전 베흘림 기둥에 서서', '최순우');");
        db.execSQL("INSERT INTO UniBook VALUES(NULL, '90', '문학과 예술의 사회사 4', '아놀드 하우저, 백낙청 옮김');");
        db.execSQL("INSERT INTO UniBook VALUES(NULL, '91', '미의 역사', '움베르트 에코');");
        db.execSQL("INSERT INTO UniBook VALUES(NULL, '92', '미학 오디세이 1', '진중권');");
        db.execSQL("INSERT INTO UniBook VALUES(NULL, '93', '서양미술사', '곰브리치, 백승길-이종숭 옮김');");
        db.execSQL("INSERT INTO UniBook VALUES(NULL, '94', '시학', '이상업');");
        db.execSQL("INSERT INTO UniBook VALUES(NULL, '95', '알랭 드 보통의 영혼의 미술관', '알랭 드 보통');");
        db.execSQL("INSERT INTO UniBook VALUES(NULL, '96', '예술이란 무엇인가', '레프 톨스토이, 이철 옮김');");
        db.execSQL("INSERT INTO UniBook VALUES(NULL, '97', '오주석의 한국의 미 특강', '오주석');");
        db.execSQL("INSERT INTO UniBook VALUES(NULL, '98', '철학을 삼킨 예술', '한상연');");
        db.execSQL("INSERT INTO UniBook VALUES(NULL, '99', '컨템로러리 아트란 무엇인가', '테리 스미스');");
        db.execSQL("INSERT INTO UniBook VALUES(NULL, '100', '흥남부두의 금순이는 어디로 갔을까', '이영미');");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        //버전이 업그레이드 됐을 경우 작업할 내용을 작성합니다.
    }
}
