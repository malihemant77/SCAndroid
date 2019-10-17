package qa.aspirezone.sc.chatassistant.network_utils;

import android.net.Uri;

public class UrlUtils {

    private static final String
            SCHEME = "https",
            AUTHORITY = "qa-www.californiapsychics.com",
            AUTH_PATH = "auth",
            OFFERS_PATH = "offers",
            TOKEN_PATH = "chat/token",
            PSYCHICS_LIST_PATH ="psychics",
            PSYCHICS_FULL_PATH="psychics/",
            ADD_FAV_PSYCHIC="psychics/",
            CHAT_RESERVE_PATH = "chat/reserve",
            START_CHAT_PATH = "chat/start",
            END_CHAT_PATH = "chat/end",
            FILTERBY_OPTIONS_PATH = "psychic/filteroptions",
            RELEASE_PSYCHIC_PATH = "chat/reserve/release",
            CUSTOMERS_DETAIL = "customers",
            PSYCHIC_STATUS_PATH="psychic/getstatus",
            PSYCHIC_SEARCH_LIST_PATH ="psychics/search",
            EDIT_EMAIL_PATH="account",
            EDIT_PASSWORD_PATH="account",
            STATE_PATH="site/states/usa",
            ONE_TIME_PAYMENT_PATH = "Chat/Charge/Onetime",
            ADD_CREDIT_CARD_PATH="chat/customers/",
            LOGOUT_PATH = "auth/logout";




    public static final Uri BASE_URI = new Uri.Builder().scheme(SCHEME).authority(AUTHORITY).build();


    public static final String
            AUTHENTICATION = BASE_URI.buildUpon().appendEncodedPath(AUTH_PATH).build().toString(),
            TOKEN = BASE_URI.buildUpon().appendEncodedPath(TOKEN_PATH).build().toString(),
            GET_CONVERSASTION_DETAIL="https://directline.botframework.com/v3/directline/conversations",
            PSYCHIC_SEARCH_LIST = BASE_URI.buildUpon().appendEncodedPath(PSYCHIC_STATUS_PATH).build().toString(),
            PSYCHICS_LIST = BASE_URI.buildUpon().appendEncodedPath(PSYCHICS_LIST_PATH).build().toString(),
            PSYCHICS_FULL_DETAIL=BASE_URI.buildUpon().appendEncodedPath(PSYCHICS_FULL_PATH).build().toString(),
            ADD_FAV_PSYCHIC_DETAIL=BASE_URI.buildUpon().appendEncodedPath(ADD_FAV_PSYCHIC).build().toString(),
            RESERVE_CHAT = BASE_URI.buildUpon().appendEncodedPath(CHAT_RESERVE_PATH).build().toString(),
            END_CHAT = BASE_URI.buildUpon().appendEncodedPath(END_CHAT_PATH).build().toString(),
            START_CHAT = BASE_URI.buildUpon().appendEncodedPath(START_CHAT_PATH).build().toString(),
            PSYCHIC_STATUS_PATH_DETAIL=BASE_URI.buildUpon().appendEncodedPath(PSYCHIC_STATUS_PATH).build().toString(),
            RELEASE_PSYCHIC =BASE_URI.buildUpon().appendEncodedPath(RELEASE_PSYCHIC_PATH).build().toString(),
            CUSTOMERS_DETAIL_PATH=BASE_URI.buildUpon().appendEncodedPath(CUSTOMERS_DETAIL).build().toString(),
            FILTERBY_OPTIONS = BASE_URI.buildUpon().appendEncodedPath(FILTERBY_OPTIONS_PATH).build().toString(),
            EDIT_EMAIL_PATH_URI=BASE_URI.buildUpon().appendEncodedPath(EDIT_EMAIL_PATH).build().toString(),
            EDIT_PASSWORD_PATH_URI=BASE_URI.buildUpon().appendEncodedPath(EDIT_PASSWORD_PATH).build().toString(),
            STATE_PATH_URI=BASE_URI.buildUpon().appendEncodedPath(STATE_PATH).build().toString(),
            ADD_CREDIT_CARD_PATH_URI=BASE_URI.buildUpon().appendEncodedPath(ADD_CREDIT_CARD_PATH).build().toString(),
            ONE_TIME_PAYMENT = BASE_URI.buildUpon().appendEncodedPath(ONE_TIME_PAYMENT_PATH).build().toString(),
            LOGOUT_URI = BASE_URI.buildUpon().appendEncodedPath(LOGOUT_PATH).build().toString();

}
