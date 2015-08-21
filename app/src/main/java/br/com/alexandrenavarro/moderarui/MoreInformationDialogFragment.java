package br.com.alexandrenavarro.moderarui;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.DialogFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * Created by alexandrenavarro on 21/08/15.
 */
public class MoreInformationDialogFragment extends DialogFragment {

    public static MoreInformationDialogFragment newInstance() {
        final MoreInformationDialogFragment dialogFragment = new MoreInformationDialogFragment();
        return dialogFragment;
    }


    @NonNull
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        View view = getActivity().getLayoutInflater().inflate(android.R.layout.select_dialog_item, null);
        TextView tvDialog = (TextView) view.findViewById(android.R.id.text1);
        tvDialog.setText("Click below to learn more!");

        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity()).setView(view);
        builder.setTitle("Inspired by works of artists such as Piet Mondrian and Ben Nicholson.");
        builder.setPositiveButton("Visit MOMA", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.moma.org"));
                startActivity(intent);
            }
        });

        builder.setNegativeButton("Not Now", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                dialogInterface.dismiss();
            }
        });


        return builder.create();
    }


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        getDialog().setCanceledOnTouchOutside(true);
        return super.onCreateView(inflater, container, savedInstanceState);
    }
}
