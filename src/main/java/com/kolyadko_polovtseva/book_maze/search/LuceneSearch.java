package com.kolyadko_polovtseva.book_maze.search;

import org.apache.lucene.analysis.Analyzer;
import org.apache.lucene.analysis.standard.StandardAnalyzer;
import org.apache.lucene.document.Document;
import org.apache.lucene.index.DirectoryReader;
import org.apache.lucene.index.IndexReader;
import org.apache.lucene.index.Term;
import org.apache.lucene.queries.TermsQuery;
import org.apache.lucene.queryparser.classic.ParseException;
import org.apache.lucene.queryparser.classic.QueryParser;
import org.apache.lucene.search.*;
import org.apache.lucene.store.Directory;
import org.apache.lucene.store.FSDirectory;
import org.apache.lucene.util.Version;

import javax.print.Doc;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by nadez on 12/17/2016.
 */
public class LuceneSearch {

    private static final String LUCENE_INDEX_DIRECTORY = "lucene";

    public static List<Integer> search(String searchString, String field) {
        TopDocs results = null;
        List<Integer> ids = new ArrayList<>();
        try (IndexReader reader = DirectoryReader.open(FSDirectory.open(Paths.get(LUCENE_INDEX_DIRECTORY)))) {
            IndexSearcher searcher = new IndexSearcher(reader);
            Analyzer analyzer = new StandardAnalyzer();
            QueryParser queryParser = new QueryParser(field, analyzer);
            Query query = queryParser.parse(searchString);
            results = searcher.search(query, 10);
            for (int i = 0; i < results.totalHits; i++) {
                Document document = searcher.doc(results.scoreDocs[i].doc);
                ids.add(Integer.parseInt(document.getField("idBook").stringValue()));
            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return ids;
    }

//    public static  searchForBooks(String query) {
//
//    }
}
