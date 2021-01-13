public double calculateEnergy(double[][] coords, int numAtoms) {

   double energySum = 0.0;

   double r0 = 1.2;

   for (int i=0; i < numAtoms-1; i++) {

       for (int j= i+1; j < numAtoms; j++) {

         double distance = Math.sqrt( (coords[i][0] - coords[j][0]) * (coords[i][0] - coords[j][0]) + 

                                                               (coords[i][1] - coords[j][1]) * (coords[i][1] - coords[j][1]) + 

                                                               (coords[i][2] - coords[j][2]) * (coords[i][2] - coords[j][2])  );

          double partialTerm1cubed= (r0/distance) * (r0/distance)*(r0/distance);

         double term2 = partialTerm1cubed * partialTerm1cubed ;

          double term1 = term2 * tem2;

          energySum = energySum + (term1 - 2.0 * term2);

      }

   }

   return energySum;

}