package o1.mobile.softhanjolup.DB;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class    DeptBook_DBHelper  extends SQLiteOpenHelper {
    String sql;

    public DeptBook_DBHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }
    @Override
    public void onCreate(SQLiteDatabase db) {
        //bookNum integer, title string, author string
        sql = "CREATE TABLE DeptBook (_id INTEGER PRIMARY KEY AUTOINCREMENT," + " bookNum INTEGER, title TEXT, author TEXT);";
        db.execSQL(sql);

        db.execSQL("INSERT INTO DeptBook VALUES(NULL, '1', '불황의 경제학', '폴 크루그먼');");
        db.execSQL("INSERT INTO DeptBook VALUES(NULL, '2', '다산 정약용 유배지에서 만나다', '박석무');");
        db.execSQL("INSERT INTO DeptBook VALUES(NULL, '3', '보이는 것과 보이지 않는 것 (문예신서 221)', '모리스 메를로 퐁티');");
        db.execSQL("INSERT INTO DeptBook VALUES(NULL, '4', '미학적 인간 호모 에스테티쿠스', '엘렌 디사나야케');");
        db.execSQL("INSERT INTO DeptBook VALUES(NULL, '5', '왜 나는 너를 사랑하는가(개정판)', '알랭 드 보통');");
        db.execSQL("INSERT INTO DeptBook VALUES(NULL, '6', '당신들의 천국', '이청준');");
        db.execSQL("INSERT INTO DeptBook VALUES(NULL, '7', '이분법을 넘어서(양장본)', '장회익');");
        db.execSQL("INSERT INTO DeptBook VALUES(NULL, '8', '총 균 쇠', '재레드 다이아몬드');");
        db.execSQL("INSERT INTO DeptBook VALUES(NULL, '9', '이중나선(궁리하는 과학 1)', '제임스 왓슨');");
        db.execSQL("INSERT INTO DeptBook VALUES(NULL, '10', '국가(플라톤의)(개정증보판)', '플라톤');");
        db.execSQL("INSERT INTO DeptBook VALUES(NULL, '11', '인간등정의 발자취', '제이콥 브로노우스키');");
        db.execSQL("INSERT INTO DeptBook VALUES(NULL, '12', '군주론(양장본)(2005)', '마키아벨리');");
        db.execSQL("INSERT INTO DeptBook VALUES(NULL, '13', '택리지(개정판)', '이중환');");
        db.execSQL("INSERT INTO DeptBook VALUES(NULL, '14', '나르치스와 골드문트(세계문학전집 66)', '헤르만 헤세');");
        db.execSQL("INSERT INTO DeptBook VALUES(NULL, '15', '난중일기(임진년 아침이 밝아오다)(오래된 책방07)', '이순신');");
        db.execSQL("INSERT INTO DeptBook VALUES(NULL, '16', '감시와 처벌', '미셸 푸코');");
        db.execSQL("INSERT INTO DeptBook VALUES(NULL, '17', '과학혁명의 구조', '토머스 S. 쿤');");
        db.execSQL("INSERT INTO DeptBook VALUES(NULL, '18', '부분과 전체(개정신판)', '하이젠베르크');");
        db.execSQL("INSERT INTO DeptBook VALUES(NULL, '19', '난장이가 쏘아올린 작은 공 외(한국소설문학대계 051)', '조세희');");
        db.execSQL("INSERT INTO DeptBook VALUES(NULL, '20', '모던 타임스 세트(전2권)', '폴 존슨');");
        db.execSQL("INSERT INTO DeptBook VALUES(NULL, '21', '광장/구운몽', '최인훈');");
        db.execSQL("INSERT INTO DeptBook VALUES(NULL, '22', '당신들의 천국', '이청준');");
        db.execSQL("INSERT INTO DeptBook VALUES(NULL, '23', '광기의 역사(현대프랑스철학총서 11)', '미셸 푸꼬');");
        db.execSQL("INSERT INTO DeptBook VALUES(NULL, '24', '마르크스의 유령들', '자크 데리다');");
        db.execSQL("INSERT INTO DeptBook VALUES(NULL, '25', '자크 라캉 세미나. 11: 정신분석의 네 가지 근본개념', '자크 알렝 밀레');");
        db.execSQL("INSERT INTO DeptBook VALUES(NULL, '26', '전체주의의 기원 1 (한길그레이트북스 83)', '한나 아렌트');");
        db.execSQL("INSERT INTO DeptBook VALUES(NULL, '27', '극단의 시대:20세기 역사(상)', '에릭 홉스봄');");
        db.execSQL("INSERT INTO DeptBook VALUES(NULL, '28', '행복의 지도: 어느 불평꾼의 기발한 세계일주', '에릭 와이너');");
        db.execSQL("INSERT INTO DeptBook VALUES(NULL, '29', '괴짜 경제학', '스티븐 레빗');");
        db.execSQL("INSERT INTO DeptBook VALUES(NULL, '30', '불안', '알랭 드 보통');");
        db.execSQL("INSERT INTO DeptBook VALUES(NULL, '31', '세계 시민주의(우리 시대의 이슈 1)', '콰메 앤터니 애피아');");
        db.execSQL("INSERT INTO DeptBook VALUES(NULL, '32', '이분법을 넘어서(양장본)', '장회익');");
        db.execSQL("INSERT INTO DeptBook VALUES(NULL, '33', '인간의 얼굴을 한 과학', '홍성욱');");
        db.execSQL("INSERT INTO DeptBook VALUES(NULL, '34', '공간의 시학(문예신서 183)', '가스통 바슐라르');");
        db.execSQL("INSERT INTO DeptBook VALUES(NULL, '35', '이중나선(궁리하는 과학 1)', '제임스 왓슨');");
        db.execSQL("INSERT INTO DeptBook VALUES(NULL, '36', '과학혁명의 구조', '토머스 S. 쿤');");
        db.execSQL("INSERT INTO DeptBook VALUES(NULL, '37', '고삐 풀린 현대성', '아르준 아파두라이');");
        db.execSQL("INSERT INTO DeptBook VALUES(NULL, '38', '리바이어던 (서해클래식)(015)', '토머스 홉스');");
        db.execSQL("INSERT INTO DeptBook VALUES(NULL, '39', '침묵의 봄', '레이첼 카슨');");
        db.execSQL("INSERT INTO DeptBook VALUES(NULL, '40', '모던 타임스. 2(양장본)', '폴 존슨');");
        db.execSQL("INSERT INTO DeptBook VALUES(NULL, '41', '전체주의의 기원 2 (한길그레이트북스 84)', '한나 아렌트');");
        db.execSQL("INSERT INTO DeptBook VALUES(NULL, '42', '극단의 시대:20세기 역사(하)', '에릭 홉스봄');");
        db.execSQL("INSERT INTO DeptBook VALUES(NULL, '43', '뜻으로 본 한국역사', '함석헌');");
        db.execSQL("INSERT INTO DeptBook VALUES(NULL, '44', '감시와 처벌', '미셸 푸코');");
        db.execSQL("INSERT INTO DeptBook VALUES(NULL, '45', '삐딱하게 보기', '슬라보예 지젝');");
        db.execSQL("INSERT INTO DeptBook VALUES(NULL, '46', '대담', '도정일');");
        db.execSQL("INSERT INTO DeptBook VALUES(NULL, '47', '세계화의 원근법', '강상중');");
        db.execSQL("INSERT INTO DeptBook VALUES(NULL, '48', '만들어진 신', '리처드 도킨스');");
        db.execSQL("INSERT INTO DeptBook VALUES(NULL, '49', '문화의 세계화(반양장)', '쟝 피에르 바르니에');");
        db.execSQL("INSERT INTO DeptBook VALUES(NULL, '50', '강의(나의 동양고전 독법)', '신영복');");
        db.execSQL("INSERT INTO DeptBook VALUES(NULL, '51', '부분과 전체(개정신판)', '하이젠베르크');");
        db.execSQL("INSERT INTO DeptBook VALUES(NULL, '52', '생명의 그물', '프리초프 카프라');");
        db.execSQL("INSERT INTO DeptBook VALUES(NULL, '53', '에밀 또는 교육론. 1(양장본)', '장 자크 루소');");
        db.execSQL("INSERT INTO DeptBook VALUES(NULL, '54', '에밀 또는 교육론. 2(양장본)', '장 자크 루소');");
        db.execSQL("INSERT INTO DeptBook VALUES(NULL, '55', '우주와 인간 사이에 질문을 던지다', '김정욱');");
        db.execSQL("INSERT INTO DeptBook VALUES(NULL, '56', '위험한 생각들(양장본)', '존 브록만');");
        db.execSQL("INSERT INTO DeptBook VALUES(NULL, '57', '자연과학의 세계 1', '김희준');");
        db.execSQL("INSERT INTO DeptBook VALUES(NULL, '58', '자연과학의 세계 2', '김희준');");
        db.execSQL("INSERT INTO DeptBook VALUES(NULL, '59', '존재의 세가지 거짓말(상):비밀노트', '아고타 크리스토프');");
        db.execSQL("INSERT INTO DeptBook VALUES(NULL, '60', '존재의 세가지 거짓말(중):타인의 증거', '아고타 크리스토프');");
        db.execSQL("INSERT INTO DeptBook VALUES(NULL, '61', '존재의 세가지 거짓말(하):50년간의 고독', '아고타 크리스토프');");
        db.execSQL("INSERT INTO DeptBook VALUES(NULL, '62', '지식인을 위한 변명', '장 폴 사르트르');");
        db.execSQL("INSERT INTO DeptBook VALUES(NULL, '63', '징비록(국역 정본)', '유성룡');");
        db.execSQL("INSERT INTO DeptBook VALUES(NULL, '64', '촛불의 미학', '가스똥 바슐라르');");
        db.execSQL("INSERT INTO DeptBook VALUES(NULL, '65', '대중 음악의 이해(케임브리지)', '사이먼 프리스 외');");
        db.execSQL("INSERT INTO DeptBook VALUES(NULL, '66', '한국과 그 이웃 나라들', '이사벨라 버드 비숍');");
        db.execSQL("INSERT INTO DeptBook VALUES(NULL, '67', '토지 세트(전21권)', '박경리');");
        db.execSQL("INSERT INTO DeptBook VALUES(NULL, '68', '강의(나의 동양고전 독법)', '신영복');");
        db.execSQL("INSERT INTO DeptBook VALUES(NULL, '69', '거의 모든것의 역사', '빌 브라이슨');");
        db.execSQL("INSERT INTO DeptBook VALUES(NULL, '70', '국가론(돋을새김 푸른책장 시리즈 006)', '플라톤');");
        db.execSQL("INSERT INTO DeptBook VALUES(NULL, '71', '근대를 다시 읽는다 세트(전2권)', '윤해동');");
        db.execSQL("INSERT INTO DeptBook VALUES(NULL, '72', '난장이가 쏘아 올린 작은 공', '조세희');");
        db.execSQL("INSERT INTO DeptBook VALUES(NULL, '73', '대화(한 지식인의 삶과 사상)(리영희저작집 11)', '리영희');");
        db.execSQL("INSERT INTO DeptBook VALUES(NULL, '74', '민주화 이후의 민주주의(개정판)', '최장집');");
        db.execSQL("INSERT INTO DeptBook VALUES(NULL, '75', '사기(한권으로 보는)', '사마천');");
        db.execSQL("INSERT INTO DeptBook VALUES(NULL, '76', '사랑은 지독한 그러나 너무나 정상적인 혼란', '울리히 벡 외');");
        db.execSQL("INSERT INTO DeptBook VALUES(NULL, '77', '사랑의 기술', '에리히 프롬');");
        db.execSQL("INSERT INTO DeptBook VALUES(NULL, '78', '서양미술사', 'E. H. 곰브리치');");
        db.execSQL("INSERT INTO DeptBook VALUES(NULL, '79', '시 읽는 기쁨', '정효구');");
        db.execSQL("INSERT INTO DeptBook VALUES(NULL, '80', '시 읽는 기쁨 2', '정효구');");
        db.execSQL("INSERT INTO DeptBook VALUES(NULL, '81', '시 읽는 기쁨 3', '정효구');");
        db.execSQL("INSERT INTO DeptBook VALUES(NULL, '82', '우리과학 100년', '박성래');");
        db.execSQL("INSERT INTO DeptBook VALUES(NULL, '83', '이기적 유전자', '리처드 도킨스');");
        db.execSQL("INSERT INTO DeptBook VALUES(NULL, '84', '책 읽는 여자는 위험하다', '슈테판 볼만');");
        db.execSQL("INSERT INTO DeptBook VALUES(NULL, '85', '최초의 3분', '스티븐 와인버그');");
        db.execSQL("INSERT INTO DeptBook VALUES(NULL, '86', '침묵의 봄', '레이첼 카슨');");
        db.execSQL("INSERT INTO DeptBook VALUES(NULL, '87', '티베트의 지혜(삶과 죽음을 바라보는)', '소걀 린포체');");
        db.execSQL("INSERT INTO DeptBook VALUES(NULL, '88', '희망의 밥상', '제인 구달');");
        db.execSQL("INSERT INTO DeptBook VALUES(NULL, '89', '제국의 선택', '즈비그뉴 브레진스키');");
        db.execSQL("INSERT INTO DeptBook VALUES(NULL, '90', '교양(사람이 알아야 할 모든 것)(특별판)', '디트리히 슈바니츠');");
        db.execSQL("INSERT INTO DeptBook VALUES(NULL, '91', '명상록(원전으로 읽는 순수 고전 세계)', '마르쿠스 아우렐리우스');");
        db.execSQL("INSERT INTO DeptBook VALUES(NULL, '92', '서유견문(조선 지식인 유길준, 서양을 번역하다)(오래된 책방08)', '유길준');");
        db.execSQL("INSERT INTO DeptBook VALUES(NULL, '93', '세계화와 그 불만', '조지프 스티글리츠');");
        db.execSQL("INSERT INTO DeptBook VALUES(NULL, '94', '토지(전21권)', '박경리');");
        db.execSQL("INSERT INTO DeptBook VALUES(NULL, '95', '문학과 예술의 사회사 세트(전4권)', '아르놀트 하우저');");
        db.execSQL("INSERT INTO DeptBook VALUES(NULL, '96', '사기(상)', '사마천');");
        db.execSQL("INSERT INTO DeptBook VALUES(NULL, '97', '사기(중)', '사마천');");
        db.execSQL("INSERT INTO DeptBook VALUES(NULL, '98', '사기(하)', '사마천');");
        db.execSQL("INSERT INTO DeptBook VALUES(NULL, '99', '마의 산 1', '토마스 만');");
        db.execSQL("INSERT INTO DeptBook VALUES(NULL, '100', '마의 산 2 (밀레니엄북스 53)', '토마스 만');");
        db.execSQL("INSERT INTO DeptBook VALUES(NULL, '101', '손자병법(한 권으로 당당하게 끝내는)(양장본)', '손무');");
        db.execSQL("INSERT INTO DeptBook VALUES(NULL, '102', '한국속의 세계(상)', '정수일');");
        db.execSQL("INSERT INTO DeptBook VALUES(NULL, '103', '한국속의 세계(하)', '정수일');");
        db.execSQL("INSERT INTO DeptBook VALUES(NULL, '104', '대화의 철학 소크라테스(세 현인 이야기1)', '고트프리트 마르틴');");
        db.execSQL("INSERT INTO DeptBook VALUES(NULL, '105', '국가론 (책세상문고 고전의세계 45)', '장 보댕');");
        db.execSQL("INSERT INTO DeptBook VALUES(NULL, '106', '민주화 이후의 민주주의(개정판)', '최장집');");
        db.execSQL("INSERT INTO DeptBook VALUES(NULL, '107', '세계체제분석(월러스틴의)', '이매뉴얼 월러스틴');");
        db.execSQL("INSERT INTO DeptBook VALUES(NULL, '108', '자유(B2B21-1)', '지그문트 바우만');");
        db.execSQL("INSERT INTO DeptBook VALUES(NULL, '109', '총 균 쇠', '재레드 다이아몬드');");
        db.execSQL("INSERT INTO DeptBook VALUES(NULL, '110', '거의 모든것의 역사', '빌 브라이슨');");
        db.execSQL("INSERT INTO DeptBook VALUES(NULL, '111', '이기적 유전자(증보판)', '리처드 도킨스');");
        db.execSQL("INSERT INTO DeptBook VALUES(NULL, '112', '과학과 종교 사이에서(과학인 김용준의 연구노트)', '김용준');");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        //버전이 업그레이드 됐을 경우 작업할 내용을 작성합니다.
    }
}
