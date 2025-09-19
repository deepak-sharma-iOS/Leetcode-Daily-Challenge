class Spreadsheet {
    private Map<String, Integer> spreadSheet = new HashMap<>();

    public Spreadsheet(int rows) {
        // for (int r = 1; r <= rows; r++) {
        //     for (char c = 'A'; c <= 'Z'; c++) {
        //         StringBuilder key = new StringBuilder();
        //         key.append(c);
        //         key.append(r);
        //         spreadSheet.put(key.toString(), 0);
        //     }
        // }
    }
    
    public void setCell(String cell, int value) {
        spreadSheet.put(cell, value);
    }
    
    public void resetCell(String cell) {
        spreadSheet.put(cell, 0);
    }
    
    public int getValue(String formula) {
        // =X+Y
        String input = formula.substring(1);
        String[] operands = input.split("\\+");

        int num1 = 0;
        int num2 = 0;

        if (isInteger(operands[0])) {
            num1 = Integer.parseInt(operands[0]);
        } else {
            num1 = spreadSheet.getOrDefault(operands[0], 0);
        }

        if (isInteger(operands[1])) {
            num2 = Integer.parseInt(operands[1]);
        } else {
            num2 = spreadSheet.getOrDefault(operands[1], 0);
        }

        return num1 + num2;
    
    }
    // A1, B1, C1
    private boolean isInteger(String str) {
        try {
            Integer.parseInt(str);
            return true;
        } catch(NumberFormatException e) {
            return false;
        }
    }
}

/**
 * Your Spreadsheet object will be instantiated and called as such:
 * Spreadsheet obj = new Spreadsheet(rows);
 * obj.setCell(cell,value);
 * obj.resetCell(cell);
 * int param_3 = obj.getValue(formula);
 */
