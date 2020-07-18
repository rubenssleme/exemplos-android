package br.org.laramara.sisnfp.utilitarios;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.util.Log;

public class ImageUtils {
	
	public static File compactarArquivo(File arquivo) {
		String caminhoArquivo = arquivo.getAbsolutePath();
		int width = 1440;
		int height = 2560;
		int qualidade = 45;

		BitmapFactory.Options bmpFactoryOptions = new BitmapFactory.Options();
		bmpFactoryOptions.inJustDecodeBounds = true;
		Bitmap bitmap = BitmapFactory.decodeFile(caminhoArquivo,
				bmpFactoryOptions);

		int heightRatio = (int) Math.ceil(bmpFactoryOptions.outHeight
				/ (float) height);
		int widthRatio = (int) Math.ceil(bmpFactoryOptions.outWidth
				/ (float) width);

		if (heightRatio > 1 || widthRatio > 1) {
			if (heightRatio > widthRatio) {
				bmpFactoryOptions.inSampleSize = heightRatio;
			} else {
				bmpFactoryOptions.inSampleSize = widthRatio;
			}
		}

		bmpFactoryOptions.inJustDecodeBounds = false;
		bitmap = BitmapFactory.decodeFile(caminhoArquivo, bmpFactoryOptions);
		try {
			bitmap.compress(Bitmap.CompressFormat.JPEG, qualidade,
					new FileOutputStream(arquivo));
		} catch (FileNotFoundException e) {
			Log.e("Erro", e.getMessage());
		}
		return arquivo;
	}
}
