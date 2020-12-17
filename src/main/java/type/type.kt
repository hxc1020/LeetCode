package type

data class FindSearchTreeCount(val max: Int, val min: Int, val isAllBST: Boolean, val maxSubBSTSize: Int)

data class DequeNode<T>(val value: T, var pre: DequeNode<T>? = null, var next: DequeNode<T>? = null)
