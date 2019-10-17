package qa.aspirezone.sc.chatassistant.customs;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Typeface;
import android.util.AttributeSet;

//import com.iquip.dprandroid.R;
//import com.outlookamusements.psychicapp.R;

import java.util.Hashtable;

import qa.aspirezone.sc.chatassistant.R;


public class TypeFaceHelper {

    private static Hashtable<String, Typeface> sFontCache = new Hashtable<>();

    private static Typeface get(String name, Context context) {
        Typeface tf = sFontCache.get(name);
        if (tf == null) {
            try {
                tf = Typeface.createFromAsset(context.getAssets(), name);
            } catch (Exception e) {
                return null;
            }
            sFontCache.put(name, tf);
        }
        return tf;
    }


    public static final int
            OPENSANS_BOLD = 0,
            OPENSANS_BOLD_ITALIC = 1,
            OPENSANS_EXTRA_BOLD = 2,
            OPENSANS_EXTRA_BOLD_ITALIC = 3,
            OPENSANS_ITALIC = 4,
            OPENSANS_LIGHT = 5,
            OPENSANS_LIGHT_ITALIC = 6,
            OPENSANS_REGULAR = 7,
            OPENSANS_SEMI_BOLD = 8,
            OPENSANS_SEMIB_BOLD_ITALIC = 9;


    private enum CustomTypeFace {
        _0("fonts/OpenSans-Bold.ttf"),
        _1("fonts/OpenSans-BoldItalic.ttf"),
        _2("fonts/OpenSans-ExtraBold.ttf"),
        _3("fonts/OpenSans-ExtraBoldItalic.ttf"),
        _4("fonts/OpenSans-Italic.ttf"),
        _5("fonts/OpenSans-Light.ttf"),
        _6("fonts/OpenSans-LightItalic.ttf"),
        _7("fonts/OpenSans-Regular.ttf"),
        _8("fonts/OpenSans-Semibold.ttf"),
        _9("fonts/OpenSans-Semibolditalic.ttf");


        private final String mFileName;

        private Hashtable<String, Typeface> mFont = new Hashtable<String, Typeface>();

        CustomTypeFace(String fileName) {
            this.mFileName = fileName;
        }

        public Typeface asTypeface(Context context) {
            return TypeFaceHelper.get(mFileName, context);
        }

        /*static CustomTypeFace fromString(String fontName) {
            return CustomTypeFace.valueOf(fontName.toUpperCase(Locale.US));
        }*/

        public static CustomTypeFace fromInt(int fontName) {
            return CustomTypeFace.valueOf("_" + fontName);
        }
    }

    public static Typeface getTypeFaceFromAttr(Context context, AttributeSet attrs, int defaultFont) {
        int fontName = defaultFont;
        if (attrs != null) {

            int[] requireAttributeValues = new int[]{R.attr.custom_font};

            TypedArray a = context.getTheme().obtainStyledAttributes(
                    attrs,
                    requireAttributeValues,
                    0,
                    0
            );
            //0 = index
            fontName = a.getInt(0, defaultFont);

            a.recycle();
        }

        return CustomTypeFace.fromInt(fontName).asTypeface(context);
    }
}
