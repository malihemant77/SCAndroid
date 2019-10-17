package qa.aspirezone.sc.chatassistant.customs;

import android.content.Context;

import android.util.AttributeSet;

import androidx.appcompat.widget.AppCompatTextView;

public class CustomFontTextView extends AppCompatTextView {

    private static final int DEFAULT_FONT_FACE = TypeFaceHelper.OPENSANS_REGULAR;

    public CustomFontTextView(Context context) {
        super(context);
        setTypeface(TypeFaceHelper.getTypeFaceFromAttr(context, null, DEFAULT_FONT_FACE));
    }

    public CustomFontTextView(Context context, AttributeSet attrs) {
        super(context, attrs);
        setTypeface(TypeFaceHelper.getTypeFaceFromAttr(context, attrs, DEFAULT_FONT_FACE));
    }

    public CustomFontTextView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        setTypeface(TypeFaceHelper.getTypeFaceFromAttr(context, attrs, DEFAULT_FONT_FACE));
    }
}