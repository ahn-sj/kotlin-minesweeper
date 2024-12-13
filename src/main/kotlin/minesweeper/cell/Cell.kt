package minesweeper.cell

data class Cell(
    val width: Width,
    val height: Height,
    var isMine: Boolean = false,
) {
    fun createMineCell(): Cell {
        return Cell(width, height, true)
    }
}
