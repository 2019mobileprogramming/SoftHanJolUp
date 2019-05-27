package o1.mobile.softhanjolup.Book;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import o1.mobile.softhanjolup.R;

public class f_book_uni_j extends Fragment {
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState){

        ViewGroup rootView = (ViewGroup)inflater.inflate(R.layout.f_book_uni_x, container, false);
        return rootView;
    }
}
