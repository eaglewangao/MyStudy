package com.ctrip.study.lucene.basic;

import java.io.IOException;
import java.io.StringReader;

import org.apache.lucene.analysis.Analyzer;
import org.apache.lucene.analysis.TokenStream;
import org.apache.lucene.analysis.cjk.CJKAnalyzer;
import org.apache.lucene.analysis.cn.ChineseAnalyzer;
import org.apache.lucene.util.Version;

public class AnalyzerDemo {
	
	public static void main(String[] args) throws Exception {
		Analyzer analyzer = new ChineseAnalyzer();
		TokenStream ts = analyzer.tokenStream("myField", new StringReader("待切分文本"));
		while(ts.incrementToken()){
			System.out.println("tocken: " + ts);
		}
	} 

}
