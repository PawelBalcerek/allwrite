package pl.allegro.tech.allwrite.recipes.spring

import org.koin.core.component.KoinComponent
import org.koin.core.component.inject
import org.openrewrite.Recipe
import pl.allegro.tech.allwrite.CliAllwriteRecipe
import pl.allegro.tech.allwrite.api.RecipeSource
import kotlin.getValue

/**
 * A recipe that performs migration e.g. from Spring Framework 6.1 to Spring Framework 6.2 (without previous migrations like 6.0->6.1, 5.3->6.0, etc.)
 */
public abstract class IsolatedSpringFrameworkRecipe(
    from: String,
    to: String,
) : CliAllwriteRecipe(
    group = "springFramework",
    action = "upgrade",
    displayName = "Migrate from Spring Framework $from to Spring Framework $to",
    from = from,
    to = to,
),
    KoinComponent {

    private val recipeSource: RecipeSource by inject()

    private val versionWithUnderscore = metadata.to?.replace(".", "_")

    override fun getRecipeList(): List<Recipe> =
        recipeSource.get("org.openrewrite.java.spring.framework.UpgradeSpringFramework_$versionWithUnderscore")
            .recipeList
            .filterNot { it.name.contains("UpgradeSpringFramework") }
}
