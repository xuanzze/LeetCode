public int romanToInt(String s) {
    char[] c = s.toCharArray();
    int output = 0;
    char prev = ' ';
    for(int i = 0; i < c.length; i++){
        char curr = c[i];
        switch(curr){
            case 'I':
                output += 1;
                break;
            case 'V':
                output += 5;
                if(prev == 'I')
                    output -= 2;
                break;
            case 'X':
                output += 10;
                if(prev == 'I')
                    output -= 2;
                break;
            case 'L':
                output += 50;
                if(prev == 'X')
                    output -= 20;
                break;
            case 'C':
                output += 100;
                if(prev == 'X')
                    output -= 20;
                break;
            case 'D':
                output += 500;
                if(prev == 'C')
                    output -= 200;
                break;
            case 'M':
                output += 1000;
                if(prev == 'C')
                    output -= 200;
                break;
        }
        prev = curr;
    }
    return output;
}
