package io.sugo.keyword;

import org.ansj.domain.Result;
import org.ansj.domain.Term;
import org.ansj.splitWord.analysis.ToAnalysis;
import org.apache.commons.lang3.math.NumberUtils;

import java.util.ArrayList;
import java.util.List;

public class Tokenizer {
	private final int leastLength;
	private final boolean keepNumeric;

	public Tokenizer(int leastLength, boolean keepNumeric) {
		this.leastLength = leastLength;
		this.keepNumeric = keepNumeric;
	}

	public Tokenizer() {
		this(2, false);
	}

	public List<String> tokenize(String text) {
		Result terms = ToAnalysis.parse(text);
		List<String> words = new ArrayList<String>();
		for (Term term : terms) {
			String word = term.getName();
			if (word.length() < leastLength) {
				continue;
			}

			if (!keepNumeric && NumberUtils.isParsable(word)) {
				continue;
			}

			words.add(word);
		}
		return words;
	}
}
