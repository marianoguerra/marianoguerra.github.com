#include <stdio.h>
#include <mpi.h>

int main (int argc, char** argv) {
	int rank, size, value, i;
	MPI_Status status;

	MPI_Init (&argc, &argv);   /* starts MPI */
	MPI_Comm_rank (MPI_COMM_WORLD, &rank);        /* get current process id */
	MPI_Comm_size (MPI_COMM_WORLD, &size);        /* get number of processes */

	do {
		if(rank == 0) {
			printf("give me a value: ");
			scanf("%d", &value);
		}

		MPI_Bcast(&value, 1, MPI_INT, 0, MPI_COMM_WORLD);
		printf("process %d received %d\n", rank, value);
		fflush(stdout);
	} while(value >= 0);
	printf("negative value, closing\n");

	MPI_Finalize();
	return 0;
}
