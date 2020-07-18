package com.aprendaefaca.cursos.controladores.activities;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.Bean;
import org.androidannotations.annotations.EActivity;
import org.androidannotations.annotations.ItemClick;
import org.androidannotations.annotations.ViewById;

import android.app.ActionBar;
import android.app.Activity;
import android.content.res.Configuration;
import android.os.Bundle;
import android.support.v4.app.ActionBarDrawerToggle;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.view.Menu;
import android.view.View;
import android.view.View.MeasureSpec;
import android.widget.ListView;

import com.aprendaefaca.cursos.IConfiguravel;
import com.aprendaefaca.cursos.Opcao;
import com.aprendaefaca.cursos.R;
import com.aprendaefaca.cursos.adaptadores.AdaptadorOpcao;

@SuppressWarnings("deprecation")
@EActivity
public abstract class ControladorTelaActivityBase extends Activity implements
		IConfiguravel {
	@Bean
	protected AdaptadorOpcao baAdaptadorOpcao;
	@ViewById(R.id.menu_lateral)
	protected ListView lvOpcoes;
	@ViewById(value = R.id.drawer_layout)
	protected DrawerLayout dlPrincipal;

	protected ActionBarDrawerToggle mDrawerToggle;
	private ActionBar abMenuSuperiorDireito;
	private CharSequence titulo;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		if (savedInstanceState == null) {
			selecionarItem(0);
		}
	}

	@AfterViews
	public void inicializar() {
		inicializarMenuLateral();
		inicializarAdaptador();
		inicializarTituloPrincipal();
	}

	private void inicializarTituloPrincipal() {
		atribuirTitulo(Opcao.INICIO.toString());
	}

	private void inicializarAdaptador() {
		lvOpcoes.setAdapter(baAdaptadorOpcao);
	}

	private void atualizarTituloAoClicarNoMenuLateral() {
		mDrawerToggle = new ActionBarDrawerToggle(this, dlPrincipal,
				R.drawable.ic_drawer, R.string.texto_drawer_open,
				R.string.texto_drawer_close) {
			public void onDrawerClosed(View view) {
				atribuirTitulo(titulo);
				atualizarMenu();
			}

			public void onDrawerOpened(View view) {
				atribuirTitulo(titulo);
				atualizarMenu();
			}
		};
	}

	private void inicializarMenuLateral() {
		habilitarClickMenuLateral(true);
		dlPrincipal.setDrawerShadow(R.drawable.drawer_shadow,
				GravityCompat.START);
		dlPrincipal.measure(MeasureSpec.EXACTLY, MeasureSpec.EXACTLY);
		atualizarTituloAoClicarNoMenuLateral();
		dlPrincipal.setDrawerListener(mDrawerToggle);
	}

	private void habilitarClickMenuLateral(boolean clicavel) {
		abMenuSuperiorDireito = getActionBar();
		abMenuSuperiorDireito.setDisplayHomeAsUpEnabled(clicavel);
		abMenuSuperiorDireito.setHomeButtonEnabled(clicavel);
	}

	@ItemClick(value = R.id.menu_lateral)
	public void clicar(int posicao) {
		String opcaoEscolhida = obterNomeOpcaoEscolhida(posicao);
		selecionarItem(posicao);
		atribuirTitulo(opcaoEscolhida);
		fecharMenuLateral();
	}

	private String obterNomeOpcaoEscolhida(int posicao) {
		String opcaoEscolhida = ((Opcao) lvOpcoes.getItemAtPosition(posicao)).nome;
		return opcaoEscolhida;
	}

	private void atualizarMenu() {
		invalidateOptionsMenu();
	}

	protected void atribuirTitulo(CharSequence titulo) {
		this.titulo = titulo;
		abMenuSuperiorDireito.setTitle(titulo);
	}

	protected void fecharMenuLateral() {
		dlPrincipal.closeDrawer(lvOpcoes);
	}

	@Override
	public void onBackPressed() {
		fecharMenuLateral();
	}

	// Sincronizacao do Menu Lateral
	@Override
	protected void onPostCreate(Bundle savedInstanceState) {
		super.onPostCreate(savedInstanceState);
		// Sync the toggle state after onRestoreInstanceState has occurred.
		mDrawerToggle.syncState();
	}

	@Override
	public void onConfigurationChanged(Configuration newConfig) {
		super.onConfigurationChanged(newConfig);
		// Pass any configuration change to the drawer toggles
		mDrawerToggle.onConfigurationChanged(newConfig);
	}

	// Menu Superior Direito
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.menu_superior_direito, menu);
		restaurarMenu();
		return true;
	}

	public void restaurarMenu() {
		abMenuSuperiorDireito
				.setNavigationMode(ActionBar.NAVIGATION_MODE_STANDARD);
		abMenuSuperiorDireito.setDisplayShowTitleEnabled(true);
		abMenuSuperiorDireito.setTitle(titulo);
	}

}
