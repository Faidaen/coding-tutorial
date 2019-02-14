class QA(name: String,department: String = "QA") : Coder(name, department) {

    val testingCapability: Int = 2

    fun releaseTesting(daysTillRelease: Int,list: ArrayList<String> ): Boolean {
        return testingCapability*daysTillRelease >= list.size
    }
}