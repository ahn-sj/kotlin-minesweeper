package minesweeper

import minesweeper.cell.Cell
import minesweeper.cell.CellRange
import minesweeper.cell.Cells
import minesweeper.cell.Height
import minesweeper.cell.Width

data class Minesweeper(
    val range: CellRange,
    val cells: Cells,
) {
    fun chooseMineCells(mine: Int): List<Cell> {
        return List(mine) {
            Cell(
                Width(range.widthRange.random()),
                Height(range.heightRange.random()),
            )
        }
    }

    companion object {
        fun setUp(range: CellRange): Minesweeper {
            return Minesweeper(
                range,
                Cells.generate(range.heightRange, range.widthRange),
            )
        }
    }
}
