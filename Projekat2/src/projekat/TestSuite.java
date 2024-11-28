package projekat;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({TestLogina.class, TestRegistracija.class, TestONama.class, TestOtvaranjeNajnovijihOglasa.class, TestPerformance.class, TestPretraga.class, TestProveraBrojaOmiljenih.class, TestProveraPodataka.class, TestPoruka.class, TestPodesavanja.class, TestDodavanjeOglasa.class})

public class TestSuite {

}
