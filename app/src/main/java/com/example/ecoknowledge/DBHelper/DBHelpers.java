package com.example.ecoknowledge.DBHelper;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import com.example.ecoknowledge.QuestionOS;

import java.util.ArrayList;
import java.util.List;

public class DBHelpers extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "Quiz.db";
    private static final String TABLE_QUEST = "questOS";
    private static final String KEY_ID = "id";
    private static final String KEY_QUES = "question";
    private static final String KEY_ANSWER = "answer"; //correct option
    private static final String KEY_OPTA = "opta"; //option a
    private static final String KEY_OPTB = "optb"; //option b
    private static final String KEY_OPTC = "optc"; //option c
    private static final String KEY_OPTD = "optd"; //option d
    private static final String KEY_CAT = "category"; //category
    private static final String TABLE_QUEST1 = "questCompFunda";
    private static final String TABLE_QUEST2 = "questHardware";
    private static final String TABLE_QUEST3 = "questFinal";

    public static final String TABLE_SCORE = "score";
    public static final String SCORE_KEY_ID = "id";
    public static final String SCORE_KEY_SECTION = "section";
    public static final String SCORE_KEY_CAT = "category";
    public static final String SCORE_KEY_SCORE = "score";

    private SQLiteDatabase dbase;

    public DBHelpers(Context context) {
        super(context, DATABASE_NAME, null, 1);
    }

    public DBHelpers(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, DATABASE_NAME, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        dbase = db;

        String sql = "CREATE TABLE IF NOT EXISTS " + TABLE_QUEST + " ( "
                + KEY_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " + KEY_QUES
                + " TEXT, " + KEY_ANSWER + " TEXT, " + KEY_OPTA + " TEXT, "
                + KEY_OPTB + " TEXT, " + KEY_OPTC + " TEXT, " + KEY_OPTD + " TEXT, " + "B" + " TEXT)";
        db.execSQL(sql);
        addQuestionsOS();

        String sql_quiz = "CREATE TABLE IF NOT EXISTS " + TABLE_SCORE + " ( "
                + SCORE_KEY_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " + SCORE_KEY_SECTION
                + " TEXT, " + SCORE_KEY_CAT + " TEXT, " + SCORE_KEY_SCORE + " INTEGER)";
        db.execSQL(sql_quiz);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }

    public void addQuestionOS(QuestionOS quest) {
        //SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(KEY_QUES, quest.getQUESTION());
        values.put(KEY_ANSWER, quest.getANSWER());
        values.put(KEY_OPTA, quest.getOPTA());
        values.put(KEY_OPTB, quest.getOPTB());
        values.put(KEY_OPTC, quest.getOPTC());
        values.put(KEY_OPTD, quest.getOPTD());
        // Inserting Row
        dbase.insert(TABLE_QUEST, null, values);
    }


    //ecoknowledge
    private void addQuestionsOS() {
        // QuestionOS q0 = new QuestionOS( "question","a" ,"b" ,"c" ,"d" ,"answer" );
        QuestionOS q1 = new QuestionOS("습지의 보호와 습지를 계속해서 이용하기 위한 국제 조약입니다. 우리나라는 101번째로 가입을 했으며 2008년 창원에서 개최가 되기도 한 이 협약은 무엇일까요?", " 기후변화협약", "람사르 협약", "환경 협약", "생물다양성 협약", "람사르 협약");
        QuestionOS q2 = new QuestionOS("지구상의 생물종을 보호하기 위해 마련된 협약이다. 여기에서 생물종이랑 지구상의 모든 생물종과 이 생물종들이 서식하는 생태계와 생물이 지닌 유전자까지도 포함된다. 이 협약의 이름은?", "바젤 협약", "람사 협약", "생물 다양성 협약", "사막화 방지 협약", "생물 다양성 협약");
        QuestionOS q3 = new QuestionOS("공기 중에는 여러 가지 오염물질이 들어 있습니다. 그 중 질소산화물, 탄화수소 등이 햇빛과 반응하여 대도시의 하늘이 뿌옇게 되는 현상을 무엇이라 할까요?", "오존과밀화", "광화학스모그", "지구온난화", "대기확산", "광화학스모그");
        QuestionOS q4 = new QuestionOS("기후 변화와 관련된 전 지구적 위험을 평가하고 국제적 대책을 마련하기 위해 세계기상기구(WMO)와 유엔환경계획(UNEP)이 공동으로 설립한 유엔 산화 국제 협의체의 이름은 무엇인가요?", "IPCC", "WWF", "UNESCO", "그린피스", "IPCC");
        QuestionOS q5 = new QuestionOS("다음중 NGO가 아닌 것을 고르세요", "그린피스", "지구의 벗", "세계자연보호기금", "환경부", "환경부");
        QuestionOS q6 = new QuestionOS("1986년 11월 스위스 바젤에 있는 의약품 대기업 회사공장에서 화재가 발생하여 창고에 있던 살충제, 유기인계 농약, 수은 화합물 등 약 30t이 강에 흘러들었는데 이에 편승하여 몇몇 화학 회사가 유독 제초제 등을 무단 방류하여 강을 오염시킨 사건은?", "메콩강 오염사건", "나일강 오염사건", "라인강 오염사건", "스네강 오염사건", "라인강 오염사건");
        QuestionOS q7 = new QuestionOS("인간이 인위적으로 만들어낸 방사능과 비슷하게 천연에서 존재하는 방사성 핵종을으로 인체에 유해한 이것은?", "자연방사능", "화산방사능", "불안전방사능", "지열방사능", "자연방사능");
        QuestionOS q8 = new QuestionOS("스모그, 산성비, 온실효과 등과 관련이 깊은 환경오염은?", "대기오염", "수질오염", "해수오염", "토양오염", "대기오염");
        QuestionOS q9 = new QuestionOS("세계에서 국가 전체적으로 쓰레기 종량제를 제일 먼저 실시한 나라는 다음중 어디일까요? ", "미국", "독일", "한국", "일본", "한국");
        QuestionOS q10 = new QuestionOS("중국이나 몽골 등 아시아 대륙의 중심부에 있는 사막과 황토 지대의 작은 모래나 황토 또는 먼지가 하늘에 떠다니다가 상층 바람을 타고 멀리까지 날아가 떨어지는 현상을 무엇이라고 하나요?", "황사현상", "지구온난화 ", "도시화 ", "백화현상 ", "황사현상");
        QuestionOS q11 = new QuestionOS("이 온실가스는 자동차운행과 공장기계가 가동될 때 많이 배출됩니다. 기후변화를 재촉하는 대표적인 이 온실가스는 무엇일까요?", "질소", "암모니아", "이산화탄소", "산소", "이산화탄소");
        QuestionOS q12 = new QuestionOS("지표면에서 약10km~50km까지를 성층권이라 합니다. 성층권 사이에 높이 약 25km 근처에 지구로 오는 강한 자외선을 흡수해 지구의 생명체를 보호해주는 이것은 무엇일까요?", "대기", "오존층", "엘리뇨", "프레온가스", "오존층");
        QuestionOS q13 = new QuestionOS("도시에서 사무실·공장·주택·자동차 등에서 발생한 먼지들이 열섬현상 때문에 흩어지지 않고 지붕을 만들어 온도가 높아지는 현상을 고르시오", "먼지지붕", "먼지온실", "공해지붕", "먼지 집", "먼지지붕");

        //14번 o/x문제라서 제외시킴. 근데 하나씩 밀렸슴 ㅠ 문제 한줄씩 바꿔서 넣어야 됨!!!!!! 14 ->15로
        QuestionOS q14 = new QuestionOS("1992년 브라질의 리우데자네이루에서 열렸던 인류 최대 환경회의의 이름은 무엇인가?", "스톡홀름회담", "리우회담", "서울선언", "드리마일섬회담", "리우회담");//
        QuestionOS q15 = new QuestionOS("국제표준화기구에서는 환경에 불이익을 주지 않는 제품을 제도적으로 인증하고 있습니다. 그린라운드에서 중요한 논의대상이 될 국제적인 환경인증제도는 무엇일까요?", "IMO 14", "IEO 1400", "ISO 14000", "ISO 2000", "ISO 14000");//
        QuestionOS q16 = new QuestionOS("카드뮴에 오염된 물을 마셔서 발생하는 병으로, 1910년 일본의 도야마현의 사람들이 뼈마디가 몹시 아픈 병으로, 심한 경우 뼈가 부러지기도 했다. 환자들이 ‘아프다 아프다’라고 소리 쳤다하여 이러한 이름을 가지게 되었다. 이 병은 무엇일까?", "이타이이타이병", "각기병", "미나마타병", "에볼라바이러스", "이타이이타이병");
        QuestionOS q17 = new QuestionOS("새집증후군에 대표 물질이라고 할 수 있는 나쁜 물질을 말해볼까요?", "식품첨가물", "납", "포름알데히드", "다이옥신", "포름알데히드");
        QuestionOS q18 = new QuestionOS("전 세계 사람들이 환경에 대해서 생각을 나누고 행동할수 있도록 기념하는 날, 즉 환경의 날은 언제일까요?", "5월 5일", "6월 5일", "1월 1일", "4월 3일", "6월 5일");
        QuestionOS q19 = new QuestionOS("세계 물의 날은 매년 언제일까요?", "1월 1일", "3월 22일", "5월 5일", "12월 25일", "3월 22일");
        QuestionOS q20 = new QuestionOS("멸종위기에 처한 야생 동·식물종의 국제거래에 관한 협약을 무엇이라고 할까요?", "런던협약", "CITES", "바젤협약", "람사협약", "CITES");
        QuestionOS q21 = new QuestionOS("겨울철이나 환절기에 이것을 입는 것만으로도 난방에 필요한 온도를 섭씨 2도 가량 낮추는 효과를 볼 수 있다고 합니다. 이것은 무엇입니까?", "양말", "오리털점퍼", "비옷", "내복", "내복");
        QuestionOS q22 = new QuestionOS("기업이 실제로는 환경에 위해 되는 물질을 배출하면서 친환경적인 이미지 광고 등을 통해 ‘녹색’ 이미지로 포장하는 것을 말한다. 이것은 무엇일까요?", "에코워시", "에코샤워", "그린샤워", "그린워시", "그린워시");
        QuestionOS q23 = new QuestionOS("자전거(bicycle)와 생태학(ecology)의 합성어로서 1971년 미국 청년의 제창으로 공해추방 시민운동으로 발전한 이 용어는 무엇일까요?", "자전거학", "에코바이크", "생태자전거", "바이콜러지", "바이콜러지");
        QuestionOS q24 = new QuestionOS("소음을 줄이기 위하여 특별히 설계된 벽으로 통기성이 없고 중량이 클수록 효과가 높다. 이 벽의 정체는 무엇일까요?", "방화벽", "차음벽", "방어벽", "보호막", "차음벽");
        QuestionOS q25 = new QuestionOS("제품생산과정에서 발생된 탄소의 총량 (탄소발자국)을 제품에 라벨 형태로 표기하는 제품은 무엇일까요?", "탄소 성적 표지 제품", "에너지 절약 제품", "친환경 인증 제품", "친환경 농산물 제품", "탄소 성적 표지 제품");
        QuestionOS q26 = new QuestionOS("이란 북부, 마잔다란 주 서부의 휴양지. 라슈트 동남동쪽, 카스피해 연안에 있음. [다른 이름] 사흐트사르 Sakht - Sar. 인구 1만 6000명 거주하며 세계 최대 습지협약이 이뤄진 대표적인 습지는 무엇일까요?", "뭄바이", "뉴델리", "람사르", "카트만두", "람사르");
        QuestionOS q27 = new QuestionOS("육지와 비슷한 생물군집을 형성하며 바다에서 그들을 둘러싼 환경과의 유기적 물질순환계를 무엇이라고 할까요?", "하늘군집", "바다군집", "해양생태계", "육지생태계", "해양생태계");
        QuestionOS q28 = new QuestionOS("다음 중 독성 해파리에 쏘였을 경우 대처요령으로 알맞은 것은?", "즉시 물 밖으로 나와, 상처 부위를 바닷물로 씻어낸다. ", "상처 부위를 살펴본 후 생수나 알콜로 씻어낸다.", "세척 후에도 촉수가 남아있을 경우 맨 손을 이용해 제거한다.", "세척 후에도 통증이 지속될 경우 상황을 좀 더 지켜본다", "즉시 물 밖으로 나와, 상처 부위를 바닷물로 씻어낸다.");
        QuestionOS q29 = new QuestionOS("나무에서 나오는 방향성 물질이며 산림욕을 통하여 심신의 피로와 스트레스를 해소할 수 있다고 하는데 이 물질은? ", "피톤치드", "테르펜", "알카로이드", "페놀화합물", "피톤치드");
        QuestionOS q30 = new QuestionOS("다음 보기 중 멸종위기 동식물이 맞는 것은?", "반달가슴곰", "고양이", "토끼", "소나무", "반달가슴곰");
        QuestionOS q31 = new QuestionOS("다음 동물들 중에서 우리나라에서 점점 사라져가고 있는 멸종위기 동물이 아닌 것은 무엇인가요?", "반달가슴곰", "저어새", "붉은귀거북", "사향노루", "붉은귀거북");
        QuestionOS q32 = new QuestionOS("곤충은 다리가 세 쌍(6개)인데 거미의 다리는 몇 쌍 일까요?", "1쌍", "2쌍", "3쌍", "4쌍", "4쌍");
        QuestionOS q33 = new QuestionOS("유전자, 생물종, 생태계라는 세가지 단계에서 다양성을 종합한 개념으로 생명의 궁극적인 원천이며 인간과 생태계 등에 필수불가결한 생명부양시스템을 유지시키는 것을 무엇이라 하나요?", "생명다양성", "생물종다양성", "종의기원", "먹이사슬", "생물종다양성");
        QuestionOS q34 = new QuestionOS("500원짜리 동전에 그려진 동물은 무엇일까요", "비둘기", "까치", "두루미", "백로", "두루미");
        QuestionOS q35 = new QuestionOS("새의 공통적인 특징입니다. 다음 괄호안에 들어갈 알맞은 단어는 무엇일까요? \n 새는 뼛속이 빨대처럼 비어 있고, 그 속에는○○(이)가 채워져 있습니다.", "물", "얼음", "기름", "공기", "공기");
        QuestionOS q36 = new QuestionOS("사막에 사는 사람들은 물을 대신하여 이것으로 갓난아기를 목욕시킨다고도 하는데, 이것은 무엇일까요?", "선인장 줄기에 저장된 물", "오아시스의 물", "낙타오줌", "모시풀", "낙타오줌");
        QuestionOS q37 = new QuestionOS("다음 중 외래종은 무엇일까요?", "참달팽이", "구상나무", "황소개구리", "섬개야광나무", "황소개구리");
        QuestionOS q38 = new QuestionOS("다음 중 식물의 특징이 아닌 것은?", "식물은 뿌리, 줄기, 잎, 꽃 등 여러 부분으로 구성되어 있다.", "식물은 동물처럼 스스로 이동하지는 못한다.", "식물의 뿌리에서 광합성이 이루어진다.", "식물은 스스로 양분을 만든다.", "식물의 뿌리에서 광합성이 이루어진다.");
        QuestionOS q39 = new QuestionOS("환경 위기 시계는 지구의 오염 심각성의 정도를 나타내는 시계입니다. 우리나라의 환경 위기 시각은 몇 시일까요?", "6시 49분", "7시 30분", "8시 50분", "9시 56분", "9시 56분");
        QuestionOS q40 = new QuestionOS("나는 개똥벌레~친구가 없네~ 노래 개똥벌레의 일부분이다. 노래의 주인공인 개똥벌레는 실제 어떤 곤충일까요?", "쇠똥구리", "반딧불이", "장수하늘소", "사슴벌레", "반딧불이");
        QuestionOS q41 = new QuestionOS("TV광고 속 북극곰의 모습을 보면 콜라를 먹고 사는 것으로 보입니다. 실제 북극곰은 지구온난화로 인해 빙하가 녹아 먹이를 구하지 못해 굶어죽거나 계속해서 수영을 하다가 지쳐 바다에 빠져죽어 그 수가 계속 줄어 멸종위기에 처하게 됐습니다. 그렇다면 북극곰의 먹이는 무엇일까요?", "시원한 콜라", "물범 등의 다른 동물", "빙하 또는 눈", "인공 사료", "물범 등의 다른 동물");
        QuestionOS q42 = new QuestionOS("도시에서 사무실·공장·주택·자동차 등에서 발생한 먼지들이 열섬현상 때문에 흩어지지 않고 지붕을 만들어 온도가 높아지는 현상을 고르시오?", "먼지지붕", "먼지온실", "공해지붕", "먼지 집", "먼지지붕");
        QuestionOS q43 = new QuestionOS("에어컨 1대의 전력소비는 선풍기 몇 대의 해당 할까요?", "10대", "20대", "30대", "40대", "30대");
        QuestionOS q44 = new QuestionOS("다음 중 친환경 에너지가 아닌 것은 무엇일까요?", "태양광", "풍력", "조력", "화력", "화력");
        QuestionOS q45 = new QuestionOS("전원을 끈 상태에서도 전기제품에서 소비되는 전력을 대기전력이라고 합니다. 다음 가전제품들 중에서 대기전력 소비가 가장 높은 물건은 무엇일까요?", "냉장고", "텔레비전 셋톱박스", "세탁기", "컴퓨터", "텔레비전 셋톱박스");
        QuestionOS q46 = new QuestionOS("생물 반응(미생물 발효나 효소 등의 이용)에 의해 생성되는 연료용 가스를 총칭하며 주요한 것으로는 메탄과 수소가 있다 이것은 무엇일까요?", "CNG", "LNG", "LPG", "BIOGAS", "BIOGAS");
        QuestionOS q47 = new QuestionOS("바이오 매스는 크게 목재, 폐기물, 에너지 식물을 이용해서 에너지를 만든다. 다음 중 에너지 식물이 아닌 것은 무엇일까요?", "유채", "밀", "사탕수수", "배추", "배추");
        QuestionOS q48 = new QuestionOS("에너지를 절약하고 건강에도 도움이 되는 여름철 적정실내온도는 몇 도일까?", "18 - 20℃ ", "22 - 24℃ ", "24 - 26℃ ", "26 - 28℃ ", "26 - 28℃ ");
        QuestionOS q49 = new QuestionOS("이 제도는 쓰레기 처리비용을 배출자가 부담토록 하여 쓰레기 발생량을 줄이고 자원 재활용도를 높이기 위한 것입니다. 우리나라에서도 지난 1995년부터 시행하고 있는 이 쓰레기 수수료 제도는 무엇일까요?", "쓰레기종량제", "폐기물예치금제", "쓰레기정액제", "폐기물부담금제", "쓰레기종량제");
        QuestionOS q50 = new QuestionOS("태평양 한가운데 있는 거대한 쓰레기 지대를 아시나요? 플라스틱 쓰레기가 90% 이상을 차지해 플라스틱 아일랜드라고도 불리는 이 섬은 지구 바다의 몇 %를 차지하고 있을까요?", "약 5%", "약 10%", "약 25%", "약 40%", "약 25%");
        QuestionOS q51 = new QuestionOS("다음 물건 중 썩어서 완전히 분해되는 시간이 가장 오래 걸리는 것은 무엇일까요?", "스티로폼", "종이컵", "비닐봉지", "물티슈", "스티로폼");
        QuestionOS q52 = new QuestionOS("이것은 혐기성 세균이 유기물을 분해할 때 생기는 가스입니다. 쓰레기 매립장에서 많이 발생하는 이 가스는 불이 잘 붙기 때문에 에너지원으로 활용할 수도 있습니다. 이 가스는 무엇입니까?", "메탄가스", "LPG", "LNG", "에탄올가스", "메탄가스");
        QuestionOS q53 = new QuestionOS("하천변에 제방을 쌓은 다음 생긴 저지대나 산 속의 계곡 지형 또는 오목한 지형으로 형성된 땅 등 규모가 큰 웅덩이 같은 토지에 수십 m씩 생활쓰레기를 매립하여 기존 지형의 형상을 완전히 뒤바뀌게 조성한 토지를 무엇이라고 할까요?", "구덩이", "매립장", "쓰레기산", "난지도", "매립장");
        QuestionOS q54 = new QuestionOS("인간이 만들어낸 플라스틱이 바다로 흘러간 후 해류의 영향으로 바다에서 빙빙 돌고 있는 섬이 있다, 우리나라 면적의 14배 정도인 이 섬을 무엇이라고 할까요?", "쓰레기 섬", "폐기물 섬", "플라스틱 섬", "인공 섬", "플라스틱 섬");
        QuestionOS q55 = new QuestionOS("불연성 쓰레기의 반대말로 불에 잘타는 물질로 종이류, 나무류, 동물성잔재물, 오니류 등을 나타낸 것은 무엇일까요?", "일반쓰레기", "음식물쓰레기", "특수 폐기물", "가연성 쓰레기", "가연성 쓰레기");
        QuestionOS q56 = new QuestionOS("자원의 소비를 줄임으로써 쓰레기 발생을 줄이는 등 소위 '3R 운동'이라 불리는 녹색 실천운동에 포함되지 않는 것은 무엇일까요?", "감량(reduction)", "재사용(reuse)", "전환(reversion)", "재활용(recycling)", "전환(reversion)");
        QuestionOS q57 = new QuestionOS("인간의 활동으로 발생된 온실가스의 증가로 인해 지구표면의 평균온도가 상승하는 현상은 ( )이다. 괄호 안에 들어갈 말은?", "기후변화", "이산화탄소 배출", "지구온난화", "온실효과", "지구온난화");
        QuestionOS q58 = new QuestionOS("지난 100년 동안 지구는 평균 0.74℃가 상승했다고 합니다. 1만년 동안 1℃ 상승한 것에 비한다면 지구가 생긴 이래 짧은 기간 동안 이렇게 온도가 급한 상승을 보인 것은 처음입니다. 이런 급격한 온도변화는 산업혁명을 중심으로 화석연료 등의 에너지 사용이 많아지고 대형건물과 자동차 사용이 늘어나면서 생겨난 현상입니다. 이런 현상에서 우리나라 또한 예외는 아닌데, 우리나라는 지난 100년간 평균 몇 ℃ 상승했을까요?", "약 0.4℃ ", "약 0.75℃ ", "약 1.5℃ ", "약 2.4℃ ", "약 1.5℃ ");
        QuestionOS q59 = new QuestionOS("스페인어로 사내아이라는 뜻을 가진 것으로 인도네시아를 비롯한 서태평양 적도 부근의 해수온도가 상승하면서 동태평양의 온도가 올라가 지구전체에 영향을 끼치게 되는 현상을 무엇이라고 할까요?", "엘리뇨", "싸이클론", "회오리", "사라", "엘리뇨");
        QuestionOS q60 = new QuestionOS("지구온난화를 일으키는 6대 온실가스가 포함되지 않는 것은 무엇인가요?", "아산화질소", "이산화탄소", "메탄", "산소", "산소");
        QuestionOS q61 = new QuestionOS("지구온난화의 주된 원인 가스인 CO2 경우 세계 배출량의 약 70%정도가 선진국에서 방출되고 있습니다. 다음 국가 중 가장 많은 CO2를 방출하는 국가는 어디일까요?", "북한", "인도", "미국", "일본", "미국");

        // 여기까지.
//        QuestionOS q62 = new QuestionOS("", "", "", "", "", "");
//        QuestionOS q63 = new QuestionOS("", "", "", "", "", "");
//        QuestionOS q64 = new QuestionOS("", "", "", "", "", "");
//        QuestionOS q65 = new QuestionOS("", "", "", "", "", "");
//        QuestionOS q66 = new QuestionOS("", "", "", "", "", "");
//        QuestionOS q67 = new QuestionOS("", "", "", "", "", "");
//        QuestionOS q68 = new QuestionOS("", "", "", "", "", "");
//        QuestionOS q69 = new QuestionOS("", "", "", "", "", "");
//        QuestionOS q70 = new QuestionOS("", "", "", "", "", "");


        this.addQuestionOS(q1);
        this.addQuestionOS(q2);
        this.addQuestionOS(q3);
        this.addQuestionOS(q4);
        this.addQuestionOS(q5);
        this.addQuestionOS(q6);
        this.addQuestionOS(q7);
        this.addQuestionOS(q8);
        this.addQuestionOS(q9);
        this.addQuestionOS(q10);
        this.addQuestionOS(q11);
        this.addQuestionOS(q12);
        this.addQuestionOS(q13);
        this.addQuestionOS(q14);
        this.addQuestionOS(q15);
        this.addQuestionOS(q16);
        this.addQuestionOS(q17);
        this.addQuestionOS(q18);
        this.addQuestionOS(q19);
        this.addQuestionOS(q20);
        this.addQuestionOS(q21);
        this.addQuestionOS(q22);
        this.addQuestionOS(q23);
        this.addQuestionOS(q24);
        this.addQuestionOS(q25);
        this.addQuestionOS(q26);
        this.addQuestionOS(q27);
        this.addQuestionOS(q28);
        this.addQuestionOS(q29);
        this.addQuestionOS(q30);
        this.addQuestionOS(q31);
        this.addQuestionOS(q32);
        this.addQuestionOS(q33);
        this.addQuestionOS(q34);
        this.addQuestionOS(q35);
        this.addQuestionOS(q36);
        this.addQuestionOS(q37);
        this.addQuestionOS(q38);
        this.addQuestionOS(q39);
        this.addQuestionOS(q40);
        this.addQuestionOS(q41);
        this.addQuestionOS(q42);
        this.addQuestionOS(q43);
        this.addQuestionOS(q44);
        this.addQuestionOS(q45);
        this.addQuestionOS(q46);
        this.addQuestionOS(q47);
        this.addQuestionOS(q48);
        this.addQuestionOS(q49);
        this.addQuestionOS(q50);
        this.addQuestionOS(q51);
        this.addQuestionOS(q52);
        this.addQuestionOS(q53);
        this.addQuestionOS(q54);
        this.addQuestionOS(q55);
        this.addQuestionOS(q56);
        this.addQuestionOS(q57);
        this.addQuestionOS(q58);
        this.addQuestionOS(q59);
        this.addQuestionOS(q60);
        this.addQuestionOS(q61);

//        this.addQuestionOS(q62);
//        this.addQuestionOS(q63);
//        this.addQuestionOS(q64);
//        this.addQuestionOS(q65);
//        this.addQuestionOS(q66);
//        this.addQuestionOS(q67);
//        this.addQuestionOS(q68);
//        this.addQuestionOS(q69);
//        this.addQuestionOS(q70);


    }

    public List<QuestionOS> getAllQuestions(String tname) {
        List<QuestionOS> quesList1 = new ArrayList<QuestionOS>();
        // String selectQuery1 = "SELECT  * FROM " + tname + " WHERE " + KEY_CAT + " = '" + lname + "'";
        String selectQuery1 = "SELECT  * FROM " + "questOS";
        String selectQuery2 = "SELECT  * FROM questOS WHERE category = 'B'";

        dbase = this.getReadableDatabase();
        Cursor cursor = dbase.rawQuery(selectQuery1, null);

        Log.d("select query1: ", selectQuery1);
        // Log.d("lname: ", lname);
        Log.d("tname: ", tname);
        // looping through all rows and adding to list
        if (cursor.moveToFirst()) {
            do {
                QuestionOS quest1 = new QuestionOS();

                quest1.setID(cursor.getInt(0));

                quest1.setQUESTION(cursor.getString(1));
                quest1.setANSWER(cursor.getString(2));

                quest1.setOPTA(cursor.getString(3));
                quest1.setOPTB(cursor.getString(4));
                quest1.setOPTC(cursor.getString(5));
                quest1.setOPTD(cursor.getString(6));

                quesList1.add(quest1);
            } while (cursor.moveToNext());
        }
        // return quest list
        return quesList1;
    }
}
