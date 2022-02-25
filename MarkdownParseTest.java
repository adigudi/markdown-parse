import static org.junit.Assert.*;
import org.junit.*;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.ArrayList;

public class MarkdownParseTest {
    @Test
    public void testSnippet1() throws IOException {
        Path fileName = Path.of("snippet1.md");
        String contents = Files.readString(fileName);
        assertEquals(List.of("url.com", "google.com"), MarkdownParse.getLinks(contents));
    }

    @Test
    public void testSnippet2() throws IOException {
        Path fileName = Path.of("snippet2.md");
        String contents = Files.readString(fileName);
        assertEquals(List.of("b.com"), MarkdownParse.getLinks(contents));
    }

    @Test
    public void testSnippet3() throws IOException {
        Path fileName = Path.of("snippet3.md");
        String contents = Files.readString(fileName);
        ArrayList<String> list = new ArrayList<>();
        list.add("https://www.twitter.com");
        list.add("https://ucsd-cse15l-w22.github.io/");
        list.add("https://cse.ucsd.edu/");
        assertEquals(List.of("url.com", "google.com"), MarkdownParse.getLinks(contents));
    }

}
