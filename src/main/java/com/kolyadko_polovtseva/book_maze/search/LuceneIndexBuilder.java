package com.kolyadko_polovtseva.book_maze.search;

import java.io.File;
import java.util.List;

import com.kolyadko_polovtseva.book_maze.entity.Book;
import org.apache.lucene.analysis.standard.StandardAnalyzer;
import org.apache.lucene.document.*;
import org.apache.lucene.index.IndexWriter;
import org.apache.lucene.index.IndexWriterConfig;
import org.apache.lucene.index.IndexableFieldType;
import org.apache.lucene.store.Directory;
import org.apache.lucene.store.FSDirectory;
import org.apache.lucene.store.RAMDirectory;
import org.apache.lucene.store.SimpleFSDirectory;
import org.apache.lucene.util.Version;


/**
 * Created by nadez on 12/17/2016.
 */
public class LuceneIndexBuilder {
    private static final String LUCENE_INDEX_DIRECTORY = "lucene";

    //method for indexing
    public static void buildIndex(Iterable<Book> books) {

        IndexWriterConfig config = new IndexWriterConfig();
        try (
                Directory index = new SimpleFSDirectory(new File(LUCENE_INDEX_DIRECTORY).toPath());
                IndexWriter writer = new IndexWriter(index, config)) {
            System.out.println("Start indexing");
            //iterate through result set
            for (Book book : books) {
                //create document object
                Document document = new Document();
                //create field objects and add to document
                Field idField = new TextField("idBook", book.getIdBook().toString(), Field.Store.YES);
                document.add(idField);
                Field nameField = new TextField("name", book.getName(), Field.Store.YES);
                document.add(nameField);
                Field descriptionField = new TextField("description", book.getDescription(), Field.Store.YES);
                document.add(descriptionField);
                //add the document to writer
                writer.addDocument(document);
            }
            //optimize the index
            System.out.println("Optimizing index");
            writer.commit();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
