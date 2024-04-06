package com.codewars.java.kyu5;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * For this exercise you will be strengthening your page-fu mastery. You will complete the PaginationHelper class,
 * which is a utility class helpful for querying paging information related to an array.
 *
 * The class is designed to take in an array of values and an integer indicating how many items will be
 * allowed per each page. The types of values contained within the collection/array are not relevant.
 *
 * The following are some examples of how this class is used:
 *
 * PaginationHelper<Character> helper = new PaginationHelper(Arrays.asList('a', 'b', 'c', 'd', 'e', 'f'), 4);
 * helper.pageCount(); // should == 2
 * helper.itemCount(); // should == 6
 * helper.pageItemCount(0); // should == 4
 * helper.pageItemCount(1); // last page - should == 2
 * helper.pageItemCount(2); // should == -1 since the page is invalid
 *
 * // pageIndex takes an item index and returns the page that it belongs on
 * helper.pageIndex(5); // should == 1 (zero based index)
 * helper.pageIndex(2); // should == 0
 * helper.pageIndex(20); // should == -1
 * helper.pageIndex(-10); // should == -1
 */
public class PaginationHelperTest {

    public static class PaginationHelper<I> {
        private final int itemCount;
        private final int pageCount;
        private final int itemsPerPage;
        private final Map<Integer, List<I>> pages;

        /**
         * The constructor takes in an array of items and a integer indicating how many
         * items fit within a single page
         */
        public PaginationHelper(List<I> collection, int itemsPerPage) {
            this.itemsPerPage = itemsPerPage;
            this.itemCount = collection.size();
            this.pages = calculatePages(collection);
            this.pageCount = pages.size();
        }

        private Map<Integer, List<I>> calculatePages(List<I> collection) {
            int pageCount = (int) Math.ceil((double) collection.size() / itemsPerPage);

            Map<Integer, List<I>> map = new HashMap<>();
            for (int i = 0; i < pageCount; i++) {
                int fromIndex = i * itemsPerPage;
                int toIndex = Math.min(fromIndex + itemsPerPage, collection.size());
                map.put(i, collection.subList(fromIndex, toIndex));
            }
            return map;
        }

        /**
         * returns the number of items within the entire collection
         */
        public int itemCount() {
            return itemCount;
        }

        /**
         * returns the number of pages
         */
        public int pageCount() {
            return pageCount;
        }

        /**
         * returns the number of items on the current page. page_index is zero based.
         * this method should return -1 for pageIndex values that are out of range
         */
        public int pageItemCount(int pageIndex) {
            int size = pages.getOrDefault(pageIndex, List.of()).size();
            return size > 0 ? size : -1;
        }

        /**
         * determines what page an item is on. Zero based indexes
         * this method should return -1 for itemIndex values that are out of range
         */
        public int pageIndex(int itemIndex) {
            if (itemIndex >= itemCount || itemIndex < 0) {
                return -1;
            }
            return itemIndex / itemsPerPage ;
        }

    }

    private PaginationHelper<Character> helper = new PaginationHelper<>(List.of('a', 'b', 'c', 'd', 'e', 'f'), 4);

    @Test
    @DisplayName("Test pageCount()")
    void testPageCount() {
        assertEquals(2, helper.pageCount(), "pageCount is returning incorrect value");
    }

    @Test
    @DisplayName("Test itemCount()")
    void testItemCount() {
        assertEquals(6, helper.itemCount(), "itemCount is returning incorrect value");
    }

    @Test
    @DisplayName("Test pageItemCount()")
    void testPageItemCount() {
        assertEquals(4, helper.pageItemCount(0), "pageItemCount is returning incorrect value for page 0");
        assertEquals(2, helper.pageItemCount(1), "pageItemCount is returning incorrect value for page 1");
        assertEquals(-1, helper.pageItemCount(2), "pageItemCount is returning incorrect value for page 2");
    }

    @Test
    @DisplayName("Test pageIndex()")
    void testPageIndex() {
        assertEquals(0, helper.pageIndex(0), "pageIndex is returning incorrect value for index 5");
        assertEquals(1, helper.pageIndex(5), "pageIndex is returning incorrect value for index 5");
        assertEquals(0, helper.pageIndex(2), "pageIndex is returning incorrect value for index 2");
        assertEquals(-1, helper.pageIndex(20), "pageIndex is returning incorrect value for index 20");
        assertEquals(-1, helper.pageIndex(-10), "pageIndex is returning incorrect value for index -10");
    }

    @Test
    @DisplayName("Empty collection")
    void emptyCollection() {
        PaginationHelper<Character> empty = new PaginationHelper<>(List.of(), 10);
        assertEquals(0, empty.itemCount(), "itemCount is returning incorrect value");
        assertEquals(0, empty.pageCount(), "pageCount is returning incorrect value");
        assertEquals(-1, empty.pageIndex(0), "pageIndex(0) called when there was an empty collection");
        assertEquals(-1, empty.pageIndex(1), "pageIndex(1) called when there was an empty collection");
        assertEquals(-1, empty.pageIndex(-1), "pageIndex(-1) called when there was an empty collection");
        assertEquals(-1, empty.pageItemCount(0), "pageItemCount is returning incorrect value for page 0");
        assertEquals(-1, empty.pageItemCount(1), "pageItemCount is returning incorrect value for page 1");
    }

}
