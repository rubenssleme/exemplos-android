package br.com.bg.apptccmobile.utilitario;

import android.content.Context;
import android.util.Log;

/**
 * Created by m7 on 11/30/16.
 */

public class ApagadorDb {

    // Padrão  singleton  garantir a criação do banco uma unica vez
    // Sem considerar a mudança de ciclo de vida (OnCreate ... etc).
    public static final ApagadorDb INSTANCIA = new ApagadorDb();

    public static ApagadorDb getInstancia() {
        return INSTANCIA;
    }

    public static void apagarDb(Context context, String nomeDb) {
        if (context.deleteDatabase(nomeDb)) {
            Log.i("ApagarDb()", nomeDb + " foi excluido com sucesso");
        } else {
            Log.e("ApagarDb()", "Falha ao excluir " + nomeDb);
        }
    }

}
