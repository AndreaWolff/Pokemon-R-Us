package nz.co.andrea.pokemon_r_us.features.common.domain;

import org.hamcrest.core.Is.`is`
import org.junit.Assert.assertThat
import org.junit.Test

class PokemonTest {

    @Test fun testDefaultGetters() {
        Pokemon("Name", "https://pokeapi.co/api/v2/pokemon/9/").run {
            assertThat(name, `is`("Name"))
            assertThat(id, `is`("9"))
        }
    }
}