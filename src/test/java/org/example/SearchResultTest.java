package org.example;

import org.junit.Test;

import static org.junit.jupiter.api.Assertions.*;
public class SearchResultTest {
    @Test
    public void IdShouldBe1() {
        SearchResult sr = new SearchResult(1, "test");
        assertEquals(1,sr.getId());
    }

    @Test
    public void NameShouldBetest() {
        SearchResult sr = new SearchResult(1, "test");
        assertEquals("test",sr.getName());
    }
}