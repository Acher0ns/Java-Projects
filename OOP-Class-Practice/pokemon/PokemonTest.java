package pokemon;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.Test;
import org.junit.platform.commons.annotation.Testable;

@Testable
public class PokemonTest {
    @Test
    public void testPokemonConst() {
        Pokemon p = new Pokemon("Ondarius", TypeIndex.DRAGON);
        String expectedName = "Ondarius";
        TypeIndex expectedType = TypeIndex.DRAGON;
        int expectedLevel = 1;

        String actualName = p.getName();
        TypeIndex actualType = p.getType();
        int actualLevel = p.getLevel();
        
        assertEquals(expectedName, actualName);
        assertEquals(expectedType, actualType);
        assertEquals(expectedLevel, actualLevel);
    }

    @Test
    public void testPokemonConstWLevel() {
        Pokemon p = new Pokemon("Ondarius", TypeIndex.DRAGON, 20);
        String expectedName = "Ondarius";
        TypeIndex expectedType = TypeIndex.DRAGON;
        int expectedLevel = 20;

        String actualName = p.getName();
        TypeIndex actualType = p.getType();
        int actualLevel = p.getLevel();
        
        assertEquals(expectedName, actualName);
        assertEquals(expectedType, actualType);
        assertEquals(expectedLevel, actualLevel);
    }

    @Test
    public void testPokemonConstWLevelOver100() {
        Pokemon p = new Pokemon("Ondarius", TypeIndex.DRAGON, 200);
        String expectedName = "Ondarius";
        TypeIndex expectedType = TypeIndex.DRAGON;
        int expectedLevel = 100;

        String actualName = p.getName();
        TypeIndex actualType = p.getType();
        int actualLevel = p.getLevel();
        
        assertEquals(expectedName, actualName);
        assertEquals(expectedType, actualType);
        assertEquals(expectedLevel, actualLevel);
    }

    @Test
    public void testPokemonLevelUp1() {
        Pokemon p = new Pokemon("Ondarius", TypeIndex.DRAGON);
        p.levelUp();
        String expectedName = "Ondarius";
        TypeIndex expectedType = TypeIndex.DRAGON;
        int expectedLevel = 2;

        String actualName = p.getName();
        TypeIndex actualType = p.getType();
        int actualLevel = p.getLevel();
        
        assertEquals(expectedName, actualName);
        assertEquals(expectedType, actualType);
        assertEquals(expectedLevel, actualLevel);
    }

    @Test
    public void testPokemonLevelUpOver100() {
        Pokemon p = new Pokemon("Ondarius", TypeIndex.DRAGON, 100);
        p.levelUp();
        String expectedName = "Ondarius";
        TypeIndex expectedType = TypeIndex.DRAGON;
        int expectedLevel = 100;

        String actualName = p.getName();
        TypeIndex actualType = p.getType();
        int actualLevel = p.getLevel();
        
        assertEquals(expectedName, actualName);
        assertEquals(expectedType, actualType);
        assertEquals(expectedLevel, actualLevel);
    }

    @Test
    public void testPokemonToString() {
        Pokemon p = new Pokemon("Ondarius", TypeIndex.DRAGON, 100);
        String expectedPString = "Pokemon{name=<Ondarius>, type=<Dragon>, level=<100>}";

        String actualPString = p.toString();
        
        assertEquals(expectedPString, actualPString);
    }

    @Test
    public void testPokemonEqualsTrue() {
        Pokemon p1 = new Pokemon("Oni", TypeIndex.DRAGON, 100);
        Pokemon p2 = new Pokemon("Ondarius", TypeIndex.DRAGON, 100);

        boolean p1EqualsP2 = p1.equals(p2);
        
        assertTrue(p1EqualsP2);
    }

    public void testPokemonEqualsFalse() {
        Pokemon p1 = new Pokemon("Oni", TypeIndex.WATER, 100);
        Pokemon p2 = new Pokemon("Ondarius", TypeIndex.DRAGON, 100);

        boolean p1EqualsP2 = p1.equals(p2);
        
        assertFalse(p1EqualsP2);
    }

    public void testPokemonEqualsFalseDiffObject() {
        Pokemon p1 = new Pokemon("Oni", TypeIndex.WATER, 100);
        int p2 = 1;

        boolean p1EqualsP2 = p1.equals(p2);
        
        assertFalse(p1EqualsP2);
    }
}
