package qa.aspirezone.sc.chatassistant.customs;

import android.app.Dialog;
import android.app.ProgressDialog;
import android.os.Bundle;
//import android.support.annotation.NonNull;
//import android.support.v4.app.DialogFragment;

import androidx.annotation.NonNull;
import androidx.fragment.app.DialogFragment;
import qa.aspirezone.sc.chatassistant.R;

//import com.iquip.dprandroid.R;

//import com.outlookamusements.psychicapp.R;


public class ProgressDialogFragment extends DialogFragment {
    private static final String
            TAG = ProgressDialogFragment.class.getSimpleName(),
            ARGS_MESSAGE = TAG + ".ARGS_MESSAGE";

    public static ProgressDialogFragment newInstance(String progressMsg) {

        Bundle args = new Bundle();
        args.putString(ARGS_MESSAGE , progressMsg );
        ProgressDialogFragment fragment = new ProgressDialogFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @NonNull
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        Bundle arguments = getArguments();
        ProgressDialog dialog = new ProgressDialog(getContext());
        setStyle(DialogFragment.STYLE_NO_FRAME, R.style.Theme_AppCompat_DayNight);
       
        dialog.setMessage(arguments.getString(ARGS_MESSAGE));
        dialog.setCancelable(false);
        setCancelable(false);
        return dialog;
    }

}
