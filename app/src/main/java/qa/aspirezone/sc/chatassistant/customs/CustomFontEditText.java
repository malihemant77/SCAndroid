package qa.aspirezone.sc.chatassistant.customs;

import android.content.Context;

import android.util.AttributeSet;

import com.google.android.material.textfield.TextInputEditText;

public class CustomFontEditText extends TextInputEditText {
    private static final int DEFAULT_FONT_FACE = TypeFaceHelper.OPENSANS_REGULAR;

    public CustomFontEditText(Context context) {
        super(context);
        setTypeface(TypeFaceHelper.getTypeFaceFromAttr(context,null,DEFAULT_FONT_FACE));
    }

    public CustomFontEditText(Context context, AttributeSet attrs) {
        super(context, attrs);
        setTypeface(TypeFaceHelper.getTypeFaceFromAttr(context,attrs,DEFAULT_FONT_FACE));
    }

    public CustomFontEditText(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        setTypeface(TypeFaceHelper.getTypeFaceFromAttr(context,attrs,DEFAULT_FONT_FACE));
    }

    @Override
    public void setError(CharSequence error) {
       super.setError(error);
    }
}
