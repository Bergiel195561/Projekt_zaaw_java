package Utils;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import static org.junit.Assert.*;

/**
 * @author krystian
 */
public class CustomHashSetTest {

    @Test
    public void notAllowedDuplicated() {
        // When
        CustomHashSet<String> customHashSet = new CustomHashSet<String>();
        int expectedNumbersOfItems = 1;

        // Given
        customHashSet.add("TEST");
        customHashSet.add("TEST");

        // Then
        assertEquals(customHashSet.size(), expectedNumbersOfItems);
    }

    @Test
    public void getElementByExistedIndex() {
        // When
        CustomHashSet<String> customHashSet = new CustomHashSet<String>();
        int indexForGet = 1;
        String expectedValue = "STRING_MASTER";

        // Given
        customHashSet.add("TESTOWY");
        customHashSet.add(expectedValue);

        // Then
        assertEquals(customHashSet.get(indexForGet), expectedValue);
    }

    @Rule
    public ExpectedException thrown = ExpectedException.none();

    @Test
    public void getElementByOutOfBoundIndex() {
        // When
        CustomHashSet<String> customHashSet = new CustomHashSet<String>();
        int indexForGet = 2;

        // Given
        customHashSet.add("TESTOWY");
        customHashSet.add("TESTOWY2");

        // Then
        thrown.expect(ArrayIndexOutOfBoundsException.class);
        customHashSet.get(indexForGet);
    }

    @Test
    public void getElementByNegativeIndex() {
        // When
        CustomHashSet<String> customHashSet = new CustomHashSet<String>();
        int indexForGet = -1;

        // Given
        customHashSet.add("TESTOWY");
        customHashSet.add("TESTOWY2");

        // Then
        thrown.expect(ArrayIndexOutOfBoundsException.class);
        customHashSet.get(indexForGet);
    }

    @Test
    public void getElementByIndexFromEmptySet() {
        // When
        CustomHashSet<String> customHashSet = new CustomHashSet<String>();
        int indexForGet = 0;

        // Given

        // Then
        thrown.expect(ArrayIndexOutOfBoundsException.class);
        customHashSet.get(indexForGet);
    }

}