package nz.co.andrea.pokemon_r_us.features.common.domain;

import org.hamcrest.core.Is.`is`
import org.junit.Assert.assertThat
import org.junit.Test

class SpritesTest {

    @Test fun testDefaultGetters() {
        Sprites("backDefault", "backShiny", "frontDefault", "frontShiny").run {
            assertThat(backDefault, `is`("backDefault"))
            assertThat(backShiny, `is`("backShiny"))
            assertThat(frontDefault, `is`("frontDefault"))
            assertThat(frontShiny, `is`("frontShiny"))
        }
    }
}