export class Task{
    id: string;
    task: string;
    stage: string;
    scope: string;
    dateCreated: string;
    dateToComplete: string;
    reminder: boolean;
    subtasks: Array<Task>;
}