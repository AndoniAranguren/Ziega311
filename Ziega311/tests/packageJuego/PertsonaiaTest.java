package packageJuego;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class PertsonaiaTest {

	Pertsonaia orkoa = new Orkoa();
	Pertsonaia elfoa = new Elfoa();
	Pertsonaia gizakia = new Gizakia();
	Pertsonaia gnomoa = new Gnomoa();

	@Before
	public void setUp() throws Exception {
		orkoa = new Orkoa();
		elfoa = new Elfoa();
		gizakia = new Gizakia();
		gnomoa = new Gnomoa();
	}

	@After
	public void tearDown() throws Exception {
		orkoa = null;
		elfoa = null;
		gizakia = null;
		gnomoa = null;
	}

	@Test
	public void testPozioaErabili() {
		orkoa.setHpCurrent(0);
		gnomoa.setHpCurrent(0);
		elfoa.setHpCurrent(0);
		gizakia.setHpCurrent(0);

		assertTrue(orkoa.hildaDago());
		assertTrue(gnomoa.hildaDago());
		assertTrue(gizakia.hildaDago());
		assertTrue(elfoa.hildaDago());

		orkoa.pozioaErabili();
		elfoa.pozioaErabili();
		gnomoa.pozioaErabili();
		gizakia.pozioaErabili();

		assertFalse(orkoa.hildaDago());
		assertFalse(gnomoa.hildaDago());
		assertFalse(gizakia.hildaDago());
		assertFalse(elfoa.hildaDago());

	}

	@Test
	public void testHildaDago() {
		orkoa.setHpCurrent(0);
		gnomoa.setHpCurrent(0);

		assertTrue(orkoa.hildaDago());
		assertTrue(gnomoa.hildaDago());
		assertFalse(gizakia.hildaDago());
		assertFalse(elfoa.hildaDago());

	}

	@Test
	public void testEkipatuObjektuBerria() {
		Kasko kaskoa = new Kasko("kasko", 10, 5, 5, 5);
		Peto petoa = new Peto("Peto", 10, 5, 5, 5);
		Galtza galtza = new Galtza("Galtza", 5, 10, 10, 10);
		Arma arma = new Arma("Arma", 0, 3, 3, 3);

		// e sartu 
		orkoa.ekipatuObjektuBerria(kaskoa);
		assertEquals(290, orkoa.getHpMax(), 0.01);
		assertNotEquals(kaskoa, orkoa.getKasko());

		// b sartu 
		orkoa.ekipatuObjektuBerria(kaskoa);
		assertEquals(kaskoa, orkoa.getKasko());
		assertEquals(300, orkoa.getHpMax(), 0.01);

		// b sartu 
		orkoa.ekipatuObjektuBerria(petoa);
		assertEquals(310, orkoa.getHpMax(), 0.01);
		assertEquals(petoa, orkoa.getPeto());

		// b sartu 
		orkoa.ekipatuObjektuBerria(galtza);
		assertEquals(315, orkoa.getHpMax(), 0.01);
		assertEquals(galtza, orkoa.getGaltza());

		// b sartu 
		orkoa.ekipatuObjektuBerria(arma);
		assertEquals(315, orkoa.getHpMax(), 0.01);
		assertEquals(arma, orkoa.getArma());

	}

	@Test
	public void testHpEguneratu() {

		orkoa.hpEguneratu(10, "behe");
		assertEquals(275, orkoa.getHpCurrent(), 1.0);

		orkoa.hpEguneratu(10, "goi");
		assertEquals(265, orkoa.getHpCurrent(), 1.0);

		orkoa.hpEguneratu(10, "estoke");
		assertEquals(255, orkoa.getHpCurrent(), 1.0);

		orkoa.hpEguneratu(-10, " ");
		assertEquals(265, orkoa.getHpCurrent(), 1.0);

		orkoa.hpEguneratu(300, "estoke");
		assertEquals(0, orkoa.getHpCurrent(), 1.0);

		orkoa.hpEguneratu(-1000, " ");
		assertEquals(orkoa.getHpMax(), orkoa.getHpCurrent(), 1.0);

		elfoa.hpEguneratu(10, "behe");
		assertEquals(225, elfoa.getHpCurrent(), 1.0);

		elfoa.hpEguneratu(10, "goi");
		assertEquals(215, elfoa.getHpCurrent(), 1.0);

		elfoa.hpEguneratu(10, "estoke");
		assertEquals(205, elfoa.getHpCurrent(), 1.0);

		gizakia.hpEguneratu(10, "behe");
		assertEquals(260, gizakia.getHpCurrent(), 1.0);

		gizakia.hpEguneratu(10, "goi");
		assertEquals(250, gizakia.getHpCurrent(), 1.0);

		gizakia.hpEguneratu(10, "estoke");
		assertEquals(235, gizakia.getHpCurrent(), 1.0);

		gnomoa.hpEguneratu(10, "behe");
		assertTrue(180 <= gnomoa.getHpCurrent() && 187 >= gnomoa.getHpCurrent());
		gnomoa.setHpCurrent(190);

		gnomoa.hpEguneratu(10, "goi");
		assertTrue(175 <= gnomoa.getHpCurrent()
				&& 185.5 >= gnomoa.getHpCurrent());
		gnomoa.setHpCurrent(190);

		gnomoa.hpEguneratu(10, "estoke");
		assertTrue(180 <= gnomoa.getHpCurrent() && 187 >= gnomoa.getHpCurrent());

	}

	@Test
	public void testHautatuErasoa() {

		// goi
		assertTrue("goi".equals(elfoa.hautatuErasoa()));
		
		// behe
		assertTrue("behe".equals(elfoa.hautatuErasoa()));

		// estoke
		assertTrue("estoke".equals(elfoa.hautatuErasoa()));

		// sahies
		assertTrue("sahies".equals(elfoa.hautatuErasoa()));

		// aztertu
		assertTrue("aztertu".equals(elfoa.hautatuErasoa()));

		// pozioa
		assertTrue("pozioa".equals(elfoa.hautatuErasoa()));

	}

	@Test
	public void testAttack() {

		double mina;

		for (int i = 0; i < 200; i++) {

			// gizakia
			mina = gizakia.attack("goi", true);
			assertTrue((mina < 46 && mina > 22) || mina == 0);
			mina = gizakia.attack("behe", true);
			assertTrue((mina < 40.5 && mina > 20) || mina == 0);
			mina = gizakia.attack("estoke", true);
			assertTrue((mina < 32.2 && mina > 16) || mina == 0);

			mina = gizakia.attack("goi", false);
			assertTrue((mina < 35 && mina > 17) || mina == 0);
			mina = gizakia.attack("behe", false);
			assertTrue((mina < 31 && mina > 15) || mina == 0);
			mina = gizakia.attack("estoke", false);
			assertTrue((mina < 24.5 && mina > 12) || mina == 0);

			// elfoa
			mina = elfoa.attack("goi", true);
			assertTrue((mina < 49 && mina > 24) || mina == 0);
			mina = elfoa.attack("behe", true);
			assertTrue((mina < 30 && mina >= 15) || mina == 0);
			mina = elfoa.attack("estoke", true);
			assertTrue((mina < 32.2 && mina > 13.5) || mina == 0);

			mina = elfoa.attack("goi", false);
			assertTrue((mina < 37 && mina > 18) || mina == 0);
			mina = elfoa.attack("behe", false);
			assertTrue((mina < 23 && mina > 11) || mina == 0);
			mina = elfoa.attack("estoke", false);
			assertTrue((mina < 28 && mina > 10) || mina == 0);

			// gnomoa
			mina = gnomoa.attack("goi", true);
			assertTrue((mina < 32.6 && mina > 16) || mina == 0);
			mina = gnomoa.attack("behe", true);
			assertTrue((mina < 34 && mina > 16.5) || mina == 0);
			mina = gnomoa.attack("estoke", true);
			assertTrue((mina < 22.5 && mina > 10.8) || mina == 0);

			mina = gnomoa.attack("goi", false);
			assertTrue((mina < 24.5 && mina > 12) || mina == 0);
			mina = gnomoa.attack("behe", false);
			assertTrue((mina < 25.5 && mina > 12.5) || mina == 0);
			mina = gnomoa.attack("estoke", false);
			assertTrue((mina < 16.7 && mina > 8) || mina == 0);

			// orkoa
			mina = orkoa.attack("goi", true);
			assertTrue((mina < 73.4 && mina > 36.4) || mina == 0);
			mina = orkoa.attack("behe", true);
			assertTrue((mina < 45 && mina > 22.4) || mina == 0);
			mina = orkoa.attack("estoke", true);
			assertTrue((mina < 36.3 && mina > 17.9) || mina == 0);

			mina = orkoa.attack("goi", false);
			assertTrue((mina < 55 && mina > 27.3) || mina == 0);
			mina = orkoa.attack("behe", false);
			assertTrue((mina < 34 && mina > 16.5) || mina == 0);
			mina = orkoa.attack("estoke", false);
			assertTrue((mina < 27.2 && mina > 13.3) || mina == 0);
		}
	}

}
