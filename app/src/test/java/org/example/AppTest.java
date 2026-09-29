package org.example;

import org.junit.jupiter.api.Test;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

class AppTest {
    @Test
    void findToolsReturnsSuggestions() throws Exception {
        List<String> suggestions = ScrapeAutocomplete.findTools();
        assertFalse(suggestions.isEmpty(), "Expected at least one suggestion");
    }
}