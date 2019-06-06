package io.sugo.pdf;

import org.apache.pdfbox.io.RandomAccessFile;
import org.apache.pdfbox.pdfparser.PDFParser;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;

import java.io.File;
import java.io.IOException;

public class PdfExtractor {
	public static String extract(String filepath) throws IOException {
		PDFParser pdfParser = new PDFParser(new RandomAccessFile(new File(filepath), "r"));
		pdfParser.parse();
		PDDocument pdDocument = new PDDocument(pdfParser.getDocument());
		PDFTextStripper pdfTextStripper = new PDFTextStripper();
		return pdfTextStripper.getText(pdDocument);
	}
}
