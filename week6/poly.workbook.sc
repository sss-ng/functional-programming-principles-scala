



class Poly(terms0: Map[Int, Double]) {
    def this(bindings: (Int, Double)*) = this(bindings.toMap)
    val terms = terms0 withDefaultValue 0.0
    def + (other: Poly) = new Poly((other.terms foldLeft terms)(addTerm))
    def addTerm(terms: Map[Int, Double], term: (Int, Double)) = {
        val (exp, coeff) = term
        terms + (exp -> (coeff + terms(exp)))
    }
    override def toString = {
        (for ((exp, coeff) <- terms.toList.sorted.reverse) 
        yield coeff + "x^" + exp) mkString " + "
    }
}



val p = new Poly(1->2, 2->3)
val p2 = new Poly(1->5, 5->6)



