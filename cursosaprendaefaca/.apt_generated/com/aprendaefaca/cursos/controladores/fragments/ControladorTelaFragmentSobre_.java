//
// DO NOT EDIT THIS FILE, IT HAS BEEN GENERATED USING AndroidAnnotations 3.2.
//


package com.aprendaefaca.cursos.controladores.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.aprendaefaca.cursos.R.layout;
import org.androidannotations.api.builder.FragmentBuilder;
import org.androidannotations.api.view.HasViews;
import org.androidannotations.api.view.OnViewChangedNotifier;

public final class ControladorTelaFragmentSobre_
    extends com.aprendaefaca.cursos.controladores.fragments.ControladorTelaFragmentSobre
    implements HasViews
{

    private final OnViewChangedNotifier onViewChangedNotifier_ = new OnViewChangedNotifier();
    private View contentView_;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        OnViewChangedNotifier previousNotifier = OnViewChangedNotifier.replaceNotifier(onViewChangedNotifier_);
        init_(savedInstanceState);
        super.onCreate(savedInstanceState);
        OnViewChangedNotifier.replaceNotifier(previousNotifier);
    }

    @Override
    public View findViewById(int id) {
        if (contentView_ == null) {
            return null;
        }
        return contentView_.findViewById(id);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        contentView_ = super.onCreateView(inflater, container, savedInstanceState);
        if (contentView_ == null) {
            contentView_ = inflater.inflate(layout.fragment_tela_sobre, container, false);
        }
        return contentView_;
    }

    @Override
    public void onDestroyView() {
        contentView_ = null;
        super.onDestroyView();
    }

    private void init_(Bundle savedInstanceState) {
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        onViewChangedNotifier_.notifyViewChanged(this);
    }

    public static ControladorTelaFragmentSobre_.FragmentBuilder_ builder() {
        return new ControladorTelaFragmentSobre_.FragmentBuilder_();
    }

    public static class FragmentBuilder_
        extends FragmentBuilder<ControladorTelaFragmentSobre_.FragmentBuilder_, com.aprendaefaca.cursos.controladores.fragments.ControladorTelaFragmentSobre>
    {


        @Override
        public com.aprendaefaca.cursos.controladores.fragments.ControladorTelaFragmentSobre build() {
            ControladorTelaFragmentSobre_ fragment_ = new ControladorTelaFragmentSobre_();
            fragment_.setArguments(args);
            return fragment_;
        }

    }

}
