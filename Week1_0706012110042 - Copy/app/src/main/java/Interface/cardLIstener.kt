package Interface

interface cardLIstener {
    fun onCardClick(position: Int)
    fun onDeleteClick(position: Int)
    fun onEditClick(position: Int)
}