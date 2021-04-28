package com.redbird.lesson24.services;

import com.redbird.lesson24.models.Author;
import com.redbird.lesson24.models.Book;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.jmx.export.annotation.ManagedOperation;
import org.springframework.jmx.export.annotation.ManagedResource;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

@Slf4j
@Service
@EnableScheduling
@ConditionalOnProperty(name = "scheduling.enabled", matchIfMissing = true)
@ManagedResource(objectName = "com.redbird.lesson22.services:name=SchedulerService",
                 description = "Scheduler service")
public class SchedulerServiceImpl implements SchedulerService {

    private final BookService bookService;
    private final AuthorService authorService;

    @Value("${backup.path}")
    private String path;

    public SchedulerServiceImpl(BookService bookService, AuthorService authorService) {
        this.bookService = bookService;
        this.authorService = authorService;
    }

    @Override
    @Scheduled(cron = "0 */30 * * * *")
    @ManagedOperation(description = "backup all db data in directory every 30 minutes")
    public void doScheduledTask() throws IOException {
        doBackup();
    }

    @PostConstruct
    private void init() throws IOException {
        try {
            Files.createDirectories(Paths.get("./" + path));
            log.info("Directory created " + path);

        }
        catch (IOException ex) {
            log.error("Failed to create directory" + ex.getMessage());
        }
    }

    public void doBackup() throws IOException {
        clearBackup();
        backupBooks(path+"/books.txt");
        backupAuthors(path+"/authors.txt");
        log.info("backup complete");
    }

    public void clearBackup() {
        File dir = new File(path);
        File[] files = dir.listFiles();
        for (File file : files) file.delete();
        log.info("clear backup directory");
    }

    public void backupBooks(String booksPath) throws IOException {
        File backupFile = new File(booksPath);
        backupFile.createNewFile();
        try(FileWriter writer = new FileWriter(backupFile, true)) {
            writer.write("id\tname\tcreationDate\tauthorId\n");
            List<Book> books =  bookService.getBooks();
            for (Book book : books) {
                writer.write(
                        book.getId() + '\t' +
                                book.getName() + '\t' +
                                book.getCreationDate() + '\t' +
                                book.getAuthor().getId() + '\n');
            }
            writer.flush();
            log.info("backup books");
        }
        catch (IOException ex) {
            log.error(ex.getMessage());
        }
    }

    public void backupAuthors(String authorPath) throws IOException {
        File backupFile = new File(authorPath);
        backupFile.createNewFile();
        try(FileWriter writer = new FileWriter(backupFile, true)) {
            writer.write("id\tfirstName\tlastName\tmiddleName\tbirthDate\n");
            List<Author> authors = authorService.getAuthors();
            for (Author author : authors) {
                writer.write(
                    author.getId() + '\t' +
                        author.getFirstName() + '\t' +
                        author.getLastName() + '\t' +
                        author.getMiddleName() + '\t' +
                        author.getBirthDate() + '\n');
            }
            writer.flush();
            log.info("backup authors");
        }
        catch (IOException ex) {
            log.error(ex.getMessage());
        }
    }
}
