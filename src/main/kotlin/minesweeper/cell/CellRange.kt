package minesweeper.cell

data class CellRange(
    val widthRange: IntRange,
    val heightRange: IntRange,
) {
    companion object {
        private const val START_RANGE = 1
        private const val ZERO = 0

        fun of(
            width: Int,
            height: Int,
        ): CellRange {
            require(width > ZERO) { "높이는 1이상이어야 합니다. input = $width" }
            require(height > ZERO) { "너비는 1이상이어야 합니다. input = $height" }

            return CellRange(
                IntRange(START_RANGE, width),
                IntRange(START_RANGE, height),
            )
        }
    }
}
