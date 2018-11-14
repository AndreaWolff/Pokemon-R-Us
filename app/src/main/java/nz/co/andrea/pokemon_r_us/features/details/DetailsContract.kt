package nz.co.andrea.pokemon_r_us.features.details

interface DetailsContract {
    interface View {
        fun finishActivity()
        fun renderName(name: String)
        fun renderImage(image: String)
        fun renderHeightLabel(label: String)
        fun renderHeight(height: String)
        fun renderWeightLabel(label: String)
        fun renderWeight(weight: String)
        fun showErrorDialog(errorTitle: String, errorMessage: String)
        fun showProgressDialog()
        fun hideProgressDialog()
    }
}