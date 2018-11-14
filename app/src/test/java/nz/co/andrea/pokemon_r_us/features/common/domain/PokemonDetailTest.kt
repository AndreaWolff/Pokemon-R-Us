package nz.co.andrea.pokemon_r_us.features.common.domain;

import org.hamcrest.core.Is.`is`
import org.junit.Assert.assertThat
import org.junit.Test

class PokemonDetailTest {

    @Test fun testDefaultGetters() {
        PokemonDetail(100,
                      "Name",
                       Sprites("back", "back_shiny", "default", "front_shiny"),
                       100).run {
            assertThat(height, `is`(100))
            assertThat(name, `is`("Name"))
            assertThat(sprites.frontDefault, `is`("default"))
            assertThat(weight, `is`(100))
        }
    }
}