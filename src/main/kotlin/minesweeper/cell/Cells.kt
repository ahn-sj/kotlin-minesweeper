package minesweeper.cell

data class Cells(val cells: List<Cell>) {
    init {
        require(cells.isNotEmpty()) { "셀은 1개 이상 이어야 합니다" }
    }

    fun placeMines(minePositions: List<Cell>): Cells {
        val mineSet = minePositions.toSet()
        return Cells(
            cells.map { cell ->
                if (cell in mineSet) {
                    cell.createMineCell()
                }
                cell
            },
        )
    }

    companion object {
        fun generate(
            heightRange: IntRange,
            widthRange: IntRange,
        ): Cells {
            val cells = heightRange.flatMap { height -> (widthRange).map { width -> Cell(Width(width), Height(height)) } }
            return Cells(cells)
        }
    }
}
