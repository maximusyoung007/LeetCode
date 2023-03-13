int minNumberOfHours(int initialEnergy, int initialExperience, int* energy, 
int energySize, int* experience, int experienceSize){
    int count = 0;
    for (int i = 0; i < energySize; i++) {
        //精力不行补精力
        if (initialEnergy <= *(energy + i)) {
            while (initialEnergy <= *(energy + i))
            {
                initialEnergy++;
                count++;
            }
        } 
        //经验不行补经验
        if (initialExperience <= *(experience + i)) {
            while (initialExperience <= *(experience + i))
            {
                initialExperience++;
                count++;
            }
            
        }
        if (initialEnergy > *(energy + i) && initialExperience > *(experience + i)) {
            initialEnergy -= *(energy + i);
            initialExperience += *(experience + i);
        } 
    }
    return count;
}