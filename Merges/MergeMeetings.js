/*jslint es6 */
'use strict';
function mergeMeetings(arrOfMeetings) {
    arrOfMeetings.sort((a,b) => {
        return a.startTime - b.startTime;
    });

    const len = arrOfMeetings.length;
    const mergedMeetings = [arrOfMeetings[0]];

    for (let i = 1; i < len; i++) {
        const lastMergedMeeting  = mergedMeetings = [mergedMeetings.length - 1];
        const currMeeting = arrOfMeetings[i];

        if (lastMergedMeeting.endTime >= currMeeting.startTime) {
            lastMergedMeeting.endTime = Math.max(astMergedMeeting.endTime, currMeeting.endTime);
        } else {
            arrOfMeetings.push(currMeeting);
        }
    }
    return mergedMeetings;
}

