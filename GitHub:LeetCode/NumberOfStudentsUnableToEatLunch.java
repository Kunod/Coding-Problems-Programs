class NumberOfStudentsUnableToEatLunch {
    public int countStudents(int[] students, int[] sandwiches) {

        int[] array = students;

        int base = 0;

        boolean flag = false;

        for (int counter = 0; counter < students.length ; )
        {
            if (array[counter] == sandwiches[base])
            {
                array[counter] = 3;
                counter = 0;
                base++;
                flag = true;
            }
            if (flag == false)
            {
                counter++;
            }
            flag = false;
            if (base == students.length)
            {
                break;
            }
        }
        
        int answer = 0;
        for (int j = 0; j<array.length; j++)
        {
            if (array[j] != 3)
            {
                answer++;
            }
        }

        return answer;
    }
    


}